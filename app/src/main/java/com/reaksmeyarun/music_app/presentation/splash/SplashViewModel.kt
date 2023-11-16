package com.reaksmeyarun.music_app.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(): ViewModel() {

    private val _state = Channel<SplashState>()
    val state = _state.receiveAsFlow()

    init {
        viewModelScope.launch {
            delay(3000L)
            _state.send(SplashState.GoToPermission)
        }
    }

}