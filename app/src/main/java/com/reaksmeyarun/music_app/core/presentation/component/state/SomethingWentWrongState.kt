package com.reaksmeyarun.music_app.core.presentation.component.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.reaksmeyarun.music_app.R
import com.reaksmeyarun.music_app.ui.theme.MusicAppTheme

@Preview(showBackground = true)
@Composable
fun PreviewSomethingWentWrong() {
    MusicAppTheme {
        SomethingWentWrongState {

        }
    }
}

@Composable
fun SomethingWentWrongState(
    tryAgainClick: () -> Unit
) {
    ScreenState(
        title = "Error!",
        description = "Sorry, there are no results for this search. Please try another phrase.",
        resource = R.drawable.ic_sth_went_wrong,
        tryAgainClick = tryAgainClick,
        tryAgainState = remember {
            mutableStateOf(true)
        }
    )
}