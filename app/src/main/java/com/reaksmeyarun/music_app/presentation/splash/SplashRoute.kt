package com.reaksmeyarun.music_app.presentation.splash

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.reaksmeyarun.music_app.core.csv.navigateTo
import com.reaksmeyarun.music_app.navigation.Route

@Composable
fun SplashScreenRoute(
    navHostController: NavHostController
) {

    val viewModel: SplashViewModel = hiltViewModel()

    SplashScreen(
        viewModel = viewModel,
        goToPermission = {
            navHostController.navigateTo(
                route = Route.PermissionScreen.name,
                popUpRoute = Route.SlashScreen.name,
                inclusive = true
            )
        }
    )
}