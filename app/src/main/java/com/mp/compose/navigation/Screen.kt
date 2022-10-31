package com.mp.compose

sealed class Screen(val route: String) {
    object Splash : Screen(route = "splash_screen")
    object Login : Screen(route = "login_screen")
    object Signup : Screen(route = "signup_screen")
    object ForgotPassword : Screen(route ="forgotpassword_screen")

    object Home : Screen(route = "home_screen")
}
