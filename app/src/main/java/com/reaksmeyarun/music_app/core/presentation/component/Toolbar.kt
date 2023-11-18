package com.reaksmeyarun.music_app.core.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reaksmeyarun.music_app.R
import com.reaksmeyarun.music_app.core.presentation.component.text.TextComponent
import com.reaksmeyarun.music_app.core.presentation.component.text.Header5TextModifier
import com.reaksmeyarun.music_app.ui.theme.MusicAppTheme

@Preview(showBackground = true)
@Composable
fun PreviewAppBar() {
    MusicAppTheme {
        Toolbar(title = "App Bar", enableBackPress = true)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    title: String = "",
    @DrawableRes res: Int = R.drawable.ic_back,
    enableBackPress: Boolean = true,
    backPressListener: () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier.padding(
            start = 8.dp,
            top = 0.dp,
            end = 0.dp,
            bottom = 0.dp
        ), title = {
            TextComponent(
                text = title,
                textModifier = Header5TextModifier()
                    .color(color = Color.White)
                    .textAlign(textAlign = TextAlign.Center),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 40.dp)
            )
        }, navigationIcon = {
            if (enableBackPress)
                IconButton(
                    modifier = Modifier.size(40.dp),
                    color = Color.White,
                    res = res,
                    onButtonClicked = backPressListener
                )
        }, colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent
        )
    )
}