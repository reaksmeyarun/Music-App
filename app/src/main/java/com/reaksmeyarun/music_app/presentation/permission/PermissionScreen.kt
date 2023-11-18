package com.reaksmeyarun.music_app.presentation.permission

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reaksmeyarun.music_app.R
import com.reaksmeyarun.music_app.core.csv.painter
import com.reaksmeyarun.music_app.core.csv.permissionNoteDescription
import com.reaksmeyarun.music_app.core.presentation.component.text.TextComponent
import com.reaksmeyarun.music_app.core.presentation.component.text.Header1TextModifier
import com.reaksmeyarun.music_app.core.presentation.component.text.Header5TextModifier
import com.reaksmeyarun.music_app.presentation.permission.component.ComponentPermission
import com.reaksmeyarun.music_app.presentation.permission.component.ComponentTopAppBar
import com.reaksmeyarun.music_app.presentation.permission.component.RationaleDialog
import com.reaksmeyarun.music_app.ui.theme.MusicAppTheme

@Composable
internal fun PermissionScreen(
    state: PermissionState,
    onEvent: (PermissionEvent) -> Unit
) {
    RationaleDialog(state = state.notification, onEvent = onEvent)
    RationaleDialog(state = state.readMedia, onEvent = onEvent)
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
                    permission = state.notification,
                    res = R.drawable.ic_notification,
                    onClick = {
                        onEvent(PermissionEvent.RequestNotificationPermission)
                    }
                )
                ComponentPermission(
                    permission = state.readMedia,
                    res = R.drawable.ic_folder,
                    onClick = {
                        onEvent(PermissionEvent.RequestReadStoragePermission)
                    }
                )
                Spacer(modifier = Modifier.height(36.dp))
                TextComponent(
                    text = stringResource(R.string.note),
                    textModifier = Header5TextModifier(),
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextComponent(
                    text = permissionNoteDescription(),
                    textModifier = Header1TextModifier()
                        .fontWeight(FontWeight.W300),
                    modifier = Modifier.padding(
                        start = 24.dp,
                        end = 24.dp,
                        bottom = 32.dp
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPermissionScreen() {
    MusicAppTheme {
        PermissionScreen(
            state = PermissionState()
        ) {

        }
    }
}