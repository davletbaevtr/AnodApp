package com.example.anod_compose.navigation

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.anod_compose.screens.*


sealed class NavRoute(val route: String) {
    object Main : NavRoute("main_screen")
    object Auth : NavRoute("auth_screen")
    object Hello : NavRoute("hello_screen")
    object SignIn : NavRoute("sigh_in_screen")
    object SignUp : NavRoute("sigh_up_screen")
}

@Composable
fun AnodNavHost(pref: SharedPreferences?) {
    val navController = rememberNavController()
    var startDestination = NavRoute.Main.route

    if (pref!!.getBoolean("is_first_launch", true)) {
        startDestination = NavRoute.Hello.route

        val editor = pref.edit()
        editor?.putBoolean("is_first_launch", false)
        editor?.apply()

    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavRoute.Hello.route) { HelloScreen(navController) }
        composable(NavRoute.Main.route) { MainScreen(navController) }
        composable(NavRoute.Auth.route) { AuthScreen(navController) }
        composable(NavRoute.SignIn.route) { SignInScreen(navController) }
        composable(NavRoute.SignUp.route) { SignUpScreen(navController) }
    }
}