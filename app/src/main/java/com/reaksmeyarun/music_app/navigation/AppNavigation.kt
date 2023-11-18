package com.reaksmeyarun.music_app.navigation

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.reaksmeyarun.music_app.core.csv.TransparentSystemBars
import com.reaksmeyarun.music_app.presentation.permission.PermissionRoute
import com.reaksmeyarun.music_app.presentation.permission.PermissionScreenRoute
import com.reaksmeyarun.music_app.presentation.permission.navigateToSettingScreen
import com.reaksmeyarun.music_app.presentation.setting.SettingScreen
import com.reaksmeyarun.music_app.presentation.splash.SplashScreenRoute
import com.reaksmeyarun.music_app.presentation.splash.navigateToHomeScreen
import com.reaksmeyarun.music_app.presentation.splash.navigateToPermissionScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current
    NavHost(
        navController = navController,
        startDestination = SplashScreenRoute
    ) {
        composable(SplashScreenRoute) {
            SplashScreenRoute(
                navigateToPermissionScreen = navController::navigateToPermissionScreen,
                navigateToHomeScreen = navController::navigateToHomeScreen
            )
        }
        composable(PermissionScreenRoute) {
            PermissionRoute(
                navigateToSettingScreen = navController::navigateToSettingScreen
            )
        }
        composable(Route.SettingScreen.name) {
            TransparentSystemBars(false)
            SettingScreen()
        }
    }
}