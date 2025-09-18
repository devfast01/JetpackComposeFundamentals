package com.example.jetpackcomposefundamentals.PhilippLacknerNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route) {
            MainScreen(navController)
        }
        composable(
            Screen.DetailScreen.route + "/{name}",
            listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Begli"
                    nullable = true
                }
            ))
        { entry ->
            DetailScreen(name = entry.arguments?.getString("name"))
        }
    }
}
