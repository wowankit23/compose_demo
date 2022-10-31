package com.mp.compose

import android.window.SplashScreen
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * Function SetupNavGraph contains the routes of screens used
 * in application.
 */
@ExperimentalMaterialApi
@Composable
fun SetupNavGraph(
    navHostController: NavHostController
) {
    /**
     * @property [systemUiController] is taken to set statusbar properties.
     */
    val systemUiController = rememberSystemUiController()

    NavHost(
        navController = navHostController,
        startDestination = Screen.Splash.route
    )


    {
        composable(route = Screen.Splash.route) {
            systemUiController.isStatusBarVisible = false
            SplashScreen(navHostController)

        }
        composable(route = Screen.Home.route) {
            //HomeScreen()
        }



    }
}
