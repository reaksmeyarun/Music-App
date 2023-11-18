package com.reaksmeyarun.music_app.presentation.splash

import androidx.navigation.NavHostController
import com.reaksmeyarun.music_app.core.csv.navigateTo
import com.reaksmeyarun.music_app.navigation.Route
import com.reaksmeyarun.music_app.presentation.permission.PermissionScreenRoute

const val SplashScreenRoute = "SlashScreen"

fun NavHostController.navigateToPermissionScreen() {
    navigateTo(
        route = PermissionScreenRoute,
        popUpRoute = SplashScreenRoute,
        inclusive = true
    )
}
fun NavHostController.navigateToHomeScreen() {
    navigateTo(
        route = Route.HomeScreen.name,
        popUpRoute = SplashScreenRoute,
        inclusive = true
    )
}