package com.reaksmeyarun.music_app.presentation.permission

import android.content.Context
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.reaksmeyarun.music_app.core.csv.LifecycleObserver
import com.reaksmeyarun.music_app.core.csv.checkPermissionStatus
import com.reaksmeyarun.music_app.core.csv.notificationPermission
import com.reaksmeyarun.music_app.core.csv.readMediaAudioPermission

@Composable
fun PermissionRoute(
    viewModel: PermissionViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val state = viewModel.state.collectAsState().value
    CheckRuntimePermission(context, viewModel::onEvent)
    PermissionScreen(
        context = context,
        state = state,
        event = viewModel.event,
        onEvent = viewModel::onEvent
    )
}

@Composable
fun CheckRuntimePermission(context: Context, onEvent: (PermissionEvent) -> Unit) {
    LifecycleObserver(context) {
        if (it == Lifecycle.Event.ON_RESUME) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                val status = context.checkPermissionStatus(notificationPermission)
                onEvent(PermissionEvent.CheckNotificationPermission(status))
            }
            val status = context.checkPermissionStatus(readMediaAudioPermission)
            onEvent(PermissionEvent.CheckReadStoragePermission(status))
        }
    }
}