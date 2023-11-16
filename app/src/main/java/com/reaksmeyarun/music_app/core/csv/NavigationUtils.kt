package com.reaksmeyarun.music_app.core.csv

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navOptions

fun NavHostController.navigateTo(
    route: String,
    popUpRoute: String,
    inclusive: Boolean = false
) {
    navigate(
        route = route,
        navOptions = navOptions {
            popUpTo(route = popUpRoute) {
                this.inclusive = inclusive
            }
        }
    )
}

fun <T> NavHostController.setResult(key: String, value: T) {
    previousBackStackEntry?.savedStateHandle?.set(key, value)
}

fun <T> NavBackStackEntry.getResult(key: String): T? {
    val value: T? = savedStateHandle[key]
    savedStateHandle["key"] = when (value) {
        is Boolean -> false
        else -> null
    }
    return value
}

fun String.arguments(p0: List<String>): String {
    var routeArguments = this
    p0.forEach { element ->
        routeArguments += "/{$element}"
    }
    return routeArguments
}

fun namedNavArgument(name: String, type: NavType<*>): NamedNavArgument {
    return navArgument(name = name) {
        this.type = type
    }
}

data class Argument(
    val name: String,
    val type: NavType<*>
)