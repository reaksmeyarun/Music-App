package com.reaksmeyarun.music_app.presentation.setting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reaksmeyarun.music_app.R
import com.reaksmeyarun.music_app.core.csv.painter
import com.reaksmeyarun.music_app.core.presentation.component.HeaderText
import com.reaksmeyarun.music_app.core.presentation.component.Toolbar
import com.reaksmeyarun.music_app.ui.theme.MusicAppTheme

@Preview(showBackground = true)
@Composable
fun PreviewSettingScreen() {
    MusicAppTheme {
        SettingScreen()
    }
}

@Composable
fun SettingScreen() {
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
                Toolbar(
                    title = stringResource(R.string.setting),
                    backPressListener = {

                    }
                )
            }
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(it)
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                HeaderText(
                    text = stringResource(R.string.language),
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}