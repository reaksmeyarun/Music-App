package com.reaksmeyarun.music_app.navigation

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.reaksmeyarun.music_app.core.csv.TransparentSystemBars
import com.reaksmeyarun.music_app.presentation.permission.PermissionRoute
import com.reaksmeyarun.music_app.presentation.setting.SettingScreen
import com.reaksmeyarun.music_app.presentation.splash.SplashScreenRoute

@Composable
fun AppNavigation() {
    val navHostController = rememberNavController()
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current
    NavHost(
        navController = navHostController,
        startDestination = Route.SlashScreen.name
    ) {
        composable(Route.SlashScreen.name) {
            TransparentSystemBars(false)
            SplashScreenRoute(navHostController = navHostController)
        }
        composable(Route.PermissionScreen.name) {
            TransparentSystemBars(false)
            PermissionRoute()
        }
        composable(Route.SettingScreen.name) {
            TransparentSystemBars(false)
            SettingScreen()
        }
    }
}