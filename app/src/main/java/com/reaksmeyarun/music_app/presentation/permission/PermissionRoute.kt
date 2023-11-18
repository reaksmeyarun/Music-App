package com.reaksmeyarun.music_app.presentation.permission

import android.content.Context
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.reaksmeyarun.music_app.core.csv.LifecycleObserver
import com.reaksmeyarun.music_app.core.csv.ObserveEvent
import com.reaksmeyarun.music_app.core.csv.TransparentSystemBars
import com.reaksmeyarun.music_app.core.csv.checkPermissionStatus
import com.reaksmeyarun.music_app.core.csv.notificationPermission
import com.reaksmeyarun.music_app.core.csv.openAppSettings
import com.reaksmeyarun.music_app.core.csv.readMediaAudioPermission
import com.reaksmeyarun.music_app.core.csv.requestPermission
import kotlinx.coroutines.flow.Flow

@Composable
fun PermissionRoute(
    navigateToSettingScreen: () -> Unit,
    viewModel: PermissionViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val state = viewModel.state.collectAsState().value
    TransparentSystemBars(useDarkIcons = false)
    ObserveEvent(
        context = context,
        event = viewModel.event,
        navigateToSettingScreen = navigateToSettingScreen
    )
    CheckPermission(context = context, onEvent = viewModel::onEvent)
    PermissionScreen(state = state, onEvent = viewModel::onEvent)
}

@Composable
fun CheckPermission(
    context: Context,
    onEvent: (PermissionEvent) -> Unit
) {
    LifecycleObserver(context) { lifeCycleEvent ->
        if (lifeCycleEvent == Lifecycle.Event.ON_RESUME) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                val status = context.checkPermissionStatus(notificationPermission)
                onEvent(PermissionEvent.UpdateNotificationPermission(status))
            }
            val status = context.checkPermissionStatus(readMediaAudioPermission)
            onEvent(PermissionEvent.UpdateReadMediaPermission(status))
        }
    }
}

@Composable
private fun ObserveEvent(
    context: Context,
    event: Flow<PermissionViewModel.Event>,
    navigateToSettingScreen: () -> Unit,
) {
    ObserveEvent(
        flow = event,
        onEvent = {
            when (it) {
                PermissionViewModel.Event.GoToSetting -> context.openAppSettings()
                PermissionViewModel.Event.RequestReadStorage ->
                    context.requestPermission(readMediaAudioPermission)

                PermissionViewModel.Event.RequestNotification ->
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                        context.requestPermission(notificationPermission)

                PermissionViewModel.Event.NavigateToSettingScreen -> navigateToSettingScreen.invoke()
            }
        }
    )
}