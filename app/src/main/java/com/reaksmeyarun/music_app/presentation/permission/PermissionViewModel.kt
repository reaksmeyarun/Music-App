package com.reaksmeyarun.music_app.presentation.permission

import android.annotation.SuppressLint
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reaksmeyarun.music_app.core.csv.EPermissionStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@SuppressLint("InlinedApi")
@HiltViewModel
class PermissionViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(savedStateHandle[State] ?: PermissionState())
    val state = _state.asStateFlow()

    private val _event = Channel<Event>()
    val event = _event.receiveAsFlow()

    fun onEvent(event: PermissionEvent) {

        viewModelScope.launch {
            when (event) {
                is PermissionEvent.CheckNotificationPermission -> updatePermissionNotification(event.status)
                is PermissionEvent.CheckReadStoragePermission -> updatePermissionReadStorage(event.status)
                PermissionEvent.DismissRationaleDialog -> dismissRationaleDialog()
                PermissionEvent.RequestNotificationPermission -> requestPermissionNotification()
                PermissionEvent.RequestReadStoragePermission -> requestPermissionReadStorage()
                PermissionEvent.GoToSetting -> {
                    dismissRationaleDialog()
                    sendUiEvent(Event.GoToSetting)
                }
            }
        }
        savedStateHandle[State] = _state.value
    }

    private suspend fun requestPermissionNotification() = if (state.value.notification.isPermissionDenied())
        _state.update { state ->
            state.copy(notification = state.notification.copy(isRationale = true))
        }
    else
        sendUiEvent(Event.RequestNotification)

    private suspend fun requestPermissionReadStorage() = if (state.value.readStorage.isPermissionDenied())
        _state.update { state ->
            state.copy(readStorage = state.readStorage.copy(isRationale = true))
        }
    else
        sendUiEvent(Event.RequestReadStorage)

    private fun updatePermissionNotification(status: EPermissionStatus) = _state.update { state ->
        state.copy(notification = state.notification.copy(status = status))
    }

    private fun updatePermissionReadStorage(status: EPermissionStatus) = _state.update { state ->
        state.copy(readStorage = state.readStorage.copy(status = status))
    }

    private fun dismissRationaleDialog() = _state.update { state ->
        state.copy(
            readStorage = state.readStorage.copy(isRationale = false),
            notification = state.notification.copy(isRationale = false)
        )
    }

    private suspend fun sendUiEvent(event: Event) {
        _event.send(event)
    }

    sealed class Event {

        object GoToSetting : Event()

        object RequestNotification : Event()

        object RequestReadStorage : Event()

    }

    companion object {
        private const val State = "PermissionViewModel-State"
    }

}