package com.reaksmeyarun.music_app.core.presentation.component.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.reaksmeyarun.music_app.R
import com.reaksmeyarun.music_app.ui.theme.MusicAppTheme

@Preview(showBackground = true)
@Composable
fun PreviewEmptyState() {
    MusicAppTheme {
        EmptyListState()
    }
}

@Composable
fun EmptyListState() {
    ScreenState(
        title = "Empty!",
        description = "All incoming requests will be listed in this folder.",
        resource = R.drawable.ic_empty,
        tryAgainState = remember {
            mutableStateOf(false)
        }
    )
}