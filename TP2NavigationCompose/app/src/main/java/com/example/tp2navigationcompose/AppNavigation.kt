package com.example.tp2navigationcompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("form") {
            FormScreen(navController = navController)
        }
        composable(
            route = "display/{name}",
            arguments = listOf(navArgument("name") { defaultValue = "" })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: "Nom inconnu"
            DisplayScreen(navController = navController, name = name)
        }
    }
}