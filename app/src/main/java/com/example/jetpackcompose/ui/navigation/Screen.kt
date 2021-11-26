package com.example.jetpackcompose.ui.navigation

sealed class Screen(val route: String) {
    object Login : Screen("user/login")
}

