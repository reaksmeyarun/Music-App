package com.reaksmeyarun.music_app.presentation.permission

import android.Manifest.*
import android.content.Context
import android.os.Build
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.reaksmeyarun.music_app.R
import com.reaksmeyarun.music_app.core.csv.ObserveFlow
import com.reaksmeyarun.music_app.core.csv.openAppSettings
import com.reaksmeyarun.music_app.core.csv.painter
import com.reaksmeyarun.music_app.core.csv.permissionNoteDescription
import com.reaksmeyarun.music_app.core.csv.requestPermission
import com.reaksmeyarun.music_app.core.presentation.component.HeaderText
import com.reaksmeyarun.music_app.core.presentation.component.NormalText
import com.reaksmeyarun.music_app.presentation.permission.component.ComponentPermission
import com.reaksmeyarun.music_app.presentation.permission.component.ComponentTopAppBar
import com.reaksmeyarun.music_app.presentation.permission.component.RationaleDialog
import com.reaksmeyarun.music_app.ui.theme.MusicAppTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Preview(showBackground = true)
@Composable
fun PreviewPermissionScreen() {
    MusicAppTheme {
        PermissionScreen(
            context = LocalContext.current,
            state = PermissionState(),
            uiEvent = flow {
                emit(PermissionViewModel.UiEvent.GoToSetting)
            }
        ) {

        }
    }
}

@Composable
internal fun PermissionScreen(
    context: Context,
    state: PermissionState,
    uiEvent: Flow<PermissionViewModel.UiEvent>,
    onEvent: (PermissionEvent) -> Unit
) {
    ObserveUiEvent(context = context, uiEvent = uiEvent)
    RationaleDialog(state = state.notification, onEvent = onEvent)
    RationaleDialog(state = state.readStorage, onEvent = onEvent)
    Box(
        modifier = Modifier.paint(
            painter = painter(id = R.mipmap.bg_dark_mode),
            contentScale = ContentScale.FillHeight
        )
    ) {
        Scaffold(
            containerColor = Color.Transparent,
            modifier = Modifier.fillMaxSize(),
            topBar = {
                ComponentTopAppBar()
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Spacer(modifier = Modifier.height(44.dp))
                ComponentPermission(
                    runtimePermission = state.notification,
                    res = R.drawable.ic_notification,
                    onClick = {
                        onEvent(PermissionEvent.RequestNotificationPermission)
                    }
                )
                ComponentPermission(
                    runtimePermission = state.readStorage,
                    res = R.drawable.ic_folder,
                    onClick = {
                        onEvent(PermissionEvent.RequestReadStoragePermission)
                    }
                )
                Spacer(modifier = Modifier.height(36.dp))
                HeaderText(
                    text = stringResource(R.string.note),
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                NormalText(
                    text = permissionNoteDescription(),
                    textSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 32.dp)
                )
            }
        }
    }
}

@Composable
private fun ObserveUiEvent(context: Context, uiEvent: Flow<PermissionViewModel.UiEvent>) {
    ObserveFlow(flow = uiEvent, onEvent = {
        when (it) {
            PermissionViewModel.UiEvent.RequestNotificationPermission -> 
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                    context.requestPermission(arrayOf(permission.POST_NOTIFICATIONS))

            PermissionViewModel.UiEvent.RequestReadStoragePermission -> {
                val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                    permission.READ_MEDIA_AUDIO
                else
                    permission.READ_EXTERNAL_STORAGE
                context.requestPermission(arrayOf(permission))
            }

            PermissionViewModel.UiEvent.GoToSetting -> openAppSettings(context)
        }
    })
}