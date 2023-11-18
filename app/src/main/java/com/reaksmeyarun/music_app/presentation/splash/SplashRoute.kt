package com.reaksmeyarun.music_app.presentation.splash

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.reaksmeyarun.music_app.core.csv.TransparentSystemBars

@Composable
fun SplashScreenRoute(
    navigateToPermissionScreen: () -> Unit,
    navigateToHomeScreen: () -> Unit,
    viewModel: SplashViewModel = hiltViewModel()
) {
    TransparentSystemBars(false)
    SplashScreen(
        viewModel = viewModel,
        navigateToPermissionScreen = navigateToPermissionScreen
    )
}