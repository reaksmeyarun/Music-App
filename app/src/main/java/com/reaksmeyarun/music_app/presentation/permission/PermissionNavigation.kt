package com.reaksmeyarun.music_app.presentation.permission

import androidx.navigation.NavController
import com.reaksmeyarun.music_app.navigation.Route

const val PermissionScreenRoute = "PermissionScreen"

fun NavController.navigateToSettingScreen() = navigate(Route.SettingScreen.name)
