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
    object SignIn: NavRoute("sigh_in_screen")
    object SignUp: NavRoute("sigh_up_screen")
}

@Composable
fun AnodNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Hello.route) { // add check new user in startDesination or add it in main idk
        composable(NavRoute.Hello.route) { HelloScreen(navController) }
        composable(NavRoute.Main.route) { MainScreen(navController) }
        composable(NavRoute.Auth.route) { AuthScreen(navController) }
        composable(NavRoute.SignIn.route) { SignInScreen(navController) }
        composable(NavRoute.SignUp.route) { SignUpScreen(navController) }
    }
}