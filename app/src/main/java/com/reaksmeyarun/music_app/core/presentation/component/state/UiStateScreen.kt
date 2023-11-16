package com.reaksmeyarun.music_app.core.presentation.component.state

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.reaksmeyarun.music_app.ui.theme.MusicAppTheme

@Preview(showBackground = true)
@Composable
fun PreviewStateScreen() {
    MusicAppTheme {
        UiStateScreen(
            emptyState = remember {
//                mutableStateOf(listOf(true, true))
                mutableStateOf(emptyList())
            }, shimmerState = remember {
                mutableStateOf(false)
            }, noInternetState = remember {
                mutableStateOf(false)
            }, somethingWentWrongState = remember {
                mutableStateOf(false)
            }, content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {

                }
            }, tryAgainClick = {

            }
        )
    }
}

@Composable
fun UiStateScreen(
    emptyState: MutableState<List<Any>> = remember {
        mutableStateOf(emptyList())
    },
    shimmerState: MutableState<Boolean> = remember {
        mutableStateOf(false)
    },
    noInternetState: MutableState<Boolean> = remember {
        mutableStateOf(false)
    },
    somethingWentWrongState: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }, content: @Composable (() -> Unit), tryAgainClick: () -> Unit
) {
    when {
        shimmerState.value -> ShimmerState()
        noInternetState.value -> NoInternetState(tryAgainClick)
        somethingWentWrongState.value -> SomethingWentWrongState(tryAgainClick)
        emptyState.value.isEmpty() -> EmptyListState()
        else -> content.invoke()
    }
}