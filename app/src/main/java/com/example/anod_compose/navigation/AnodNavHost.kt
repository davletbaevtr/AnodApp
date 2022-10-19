package com.example.anod_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.anod_compose.screens.*

sealed class NavRoute(val route: String){
    object Main: NavRoute("main_screen")
    object Auth: NavRoute("auth_screen")
    object Hello: NavRoute("hello_screen")
}

@Composable
fun AnodNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Hello.route) {
        composable(NavRoute.Hello.route) { HelloScreen(navController) }
        composable(NavRoute.Main.route) { MainScreen(navController) }
        composable(NavRoute.Auth.route) { AuthScreen(navController) }
    }
}