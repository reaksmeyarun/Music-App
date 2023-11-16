package com.reaksmeyarun.music_app.core.presentation.component.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.reaksmeyarun.music_app.R
import com.reaksmeyarun.music_app.ui.theme.MusicAppTheme

@Preview(showBackground = true)
@Composable
fun PreviewNoInternetState() {
    MusicAppTheme {
        NoInternetState {

        }
    }
}

@Composable
fun NoInternetState(
    tryAgainClick: () -> Unit
) {
    ScreenState(
        title = "No Internet connection",
        description = "No Internet connection found. Check your connection or try again.",
        resource = R.drawable.ic_no_internet,
        tryAgainClick = tryAgainClick,
        tryAgainState = remember {
            mutableStateOf(true)
        }
    )
}