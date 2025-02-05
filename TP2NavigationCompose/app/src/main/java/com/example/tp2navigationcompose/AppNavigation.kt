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
            route = "display/{name}/{age}",
            arguments = listOf(
                navArgument("name") { defaultValue = "" },
                navArgument("age") { defaultValue = "0" }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: "Nom inconnu"
            val age = backStackEntry.arguments?.getString("age") ?: "Âge inconnu"
            DisplayScreen(navController = navController, name = name, age = age)
        }
    }
}