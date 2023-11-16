package com.reaksmeyarun.music_app.presentation.permission

import android.Manifest
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.reaksmeyarun.music_app.core.csv.LifecycleObserver
import com.reaksmeyarun.music_app.core.csv.TransparentSystemBars
import com.reaksmeyarun.music_app.core.csv.checkPermissionEvent

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
        uiEvent = viewModel.uiEvent,
        onEvent = viewModel::onEvent
    )
}


@Composable
fun CheckRuntimePermission(context: Context, onEvent: (PermissionEvent) -> Unit) {
    LifecycleObserver(context) {
        if (it == Lifecycle.Event.ON_RESUME) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                val status = context.checkPermissionEvent(permission = Manifest.permission.POST_NOTIFICATIONS)
                onEvent(PermissionEvent.CheckNotificationPermission(status))
            }
            val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                Manifest.permission.READ_MEDIA_AUDIO
            else
                Manifest.permission.READ_EXTERNAL_STORAGE
            val status = context.checkPermissionEvent(permission = permission)
            onEvent(PermissionEvent.CheckReadStoragePermission(status))
        }
    }
}