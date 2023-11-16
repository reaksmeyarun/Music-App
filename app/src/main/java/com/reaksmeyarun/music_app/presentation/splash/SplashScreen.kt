package com.reaksmeyarun.music_app.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.reaksmeyarun.music_app.R
import com.reaksmeyarun.music_app.core.csv.ObserveEvent
import com.reaksmeyarun.music_app.core.csv.TransparentSystemBars
import com.reaksmeyarun.music_app.core.csv.painter
import com.reaksmeyarun.music_app.ui.theme.MusicAppTheme

@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    MusicAppTheme {
        SplashScreen(SplashViewModel()) {

        }
    }
}


@Composable
fun SplashScreen(
    viewModel: SplashViewModel,
    goToPermission: () -> Unit
) {
    TransparentSystemBars(false)
    ObserveState(viewModel = viewModel, goToPermission = goToPermission)
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.ios_white_loading)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition, iterations = LottieConstants.IterateForever
    )
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painter(id = R.mipmap.bg_dark_mode),
                contentScale = ContentScale.FillHeight
            )
    ) {
        val (logo, loading, txtVersion) = createRefs()
        Image(
            painter = painter(id = R.drawable.ic_music_app),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .constrainAs(logo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(parent.top)
                })
        LottieAnimation(
            composition = composition,
            progress = {
                progress
            }, modifier = Modifier
                .size(40.dp)
                .constrainAs(loading) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(logo.bottom)
                })
        Text(
            text = "Version: 1.0.0",
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .constrainAs(txtVersion) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}

@Composable
fun ObserveState(viewModel: SplashViewModel, goToPermission: () -> Unit) {
    ObserveEvent(
        flow = viewModel.state,
        onEvent = {
            when (it) {
                SplashState.GoToPermission -> goToPermission.invoke()
            }
        }
    )
}