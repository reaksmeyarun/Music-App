package com.reaksmeyarun.music_app.presentation.permission

import android.Manifest
import android.annotation.SuppressLint
import android.os.Build
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reaksmeyarun.music_app.core.csv.EPermissionStatus
import com.reaksmeyarun.music_app.core.csv.RuntimePermissionModel
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

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private val readStoragePermission by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            Manifest.permission.READ_MEDIA_AUDIO
        else
            Manifest.permission.READ_EXTERNAL_STORAGE
    }
    private val notificationPermission by lazy {
        Manifest.permission.POST_NOTIFICATIONS
    }

    init {
        _state.update { state ->
            state.copy(
                notification = RuntimePermissionModel(
                    permission = notificationPermission
                ),
                readStorage = RuntimePermissionModel(
                    permission = readStoragePermission
                )
            )
        }
    }

    fun onEvent(event: PermissionEvent) {
        viewModelScope.launch {
            when (event) {
                is PermissionEvent.CheckNotificationPermission -> _state.update { state ->
                    state.copy(
                        notification = state.notification.copy(status = event.status)
                    )
                }

                is PermissionEvent.CheckReadStoragePermission -> _state.update { state ->
                    state.copy(
                        readStorage = state.readStorage.copy(status = event.status)
                    )
                }

                PermissionEvent.DismissRationaleDialog -> _state.update { state ->
                    state.copy(
                        readStorage = state.readStorage.copy(isRationale = false),
                        notification = state.notification.copy(isRationale = false)
                    )
                }

                PermissionEvent.RequestNotificationPermission ->
                    if (state.value.notification.status == EPermissionStatus.PermissionDenied)
                        _state.update { state ->
                            state.copy(notification = state.notification.copy(isRationale = true))
                        }
                    else
                        _uiEvent.send(UiEvent.RequestNotificationPermission)

                PermissionEvent.RequestReadStoragePermission ->
                    if (state.value.readStorage.status == EPermissionStatus.PermissionDenied)
                        _state.update { state ->
                            state.copy(readStorage = state.readStorage.copy(isRationale = true))
                        }
                    else
                        _uiEvent.send(UiEvent.RequestReadStoragePermission)

                PermissionEvent.GoToSetting -> {
                    _state.update { state ->
                        state.copy(
                            readStorage = state.readStorage.copy(isRationale = false),
                            notification = state.notification.copy(isRationale = false)
                        )
                    }
                    _uiEvent.send(UiEvent.GoToSetting)
                }
            }
        }
        savedStateHandle[State] = _state.value
    }

    sealed class UiEvent {

        object RequestNotificationPermission : UiEvent()

        object RequestReadStoragePermission : UiEvent()

        object GoToSetting : UiEvent()

    }

    companion object {
        private const val State = "PermissionViewModel-State"
    }

}