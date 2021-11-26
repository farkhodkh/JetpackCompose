package com.example.jetpackcompose.ui.theme

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.runtime.Composable
import androidx.navigation.plusAssign
import com.example.jetpackcompose.ui.login.LoginScreen
import com.example.jetpackcompose.ui.main.MainView
import com.example.jetpackcompose.ui.navigation.Screen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator

@ExperimentalMaterialNavigationApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
@Suppress("LongMethod")
fun AppNavGraph() {
    val navController = rememberAnimatedNavController()
    val tabNavController = rememberAnimatedNavController()
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    navController.navigatorProvider += bottomSheetNavigator

    ModalBottomSheetLayout(
        sheetContent = bottomSheetNavigator.sheetContent
    ) {
        AnimatedNavHost(
            navController,
            startDestination = TABS_GRAPH_NAV_ROUTE
        ) {
            composable(TABS_GRAPH_NAV_ROUTE) {
                MainView(
                    onClickListener = {
                        navController.navigate(Screen.Login.route)
                    }
                )
            }
            composable(Screen.Login.route) {
                LoginScreen(

                )
            }
        }
    }
}

private const val TABS_GRAPH_NAV_ROUTE = "root"