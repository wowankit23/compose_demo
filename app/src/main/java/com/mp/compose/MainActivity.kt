package com.mp.compose

import android.content.Context
import android.graphics.drawable.ColorDrawable

import android.os.Bundle
import android.util.Size
import android.view.View
import android.view.WindowManager
import androidx.compose.material.Surface


import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mp.compose.ui.theme.MobileProgrammingTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * This is an entry level class for the application
 */
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    /**
     * @property[navHostController] is used to navigate between routes defined in application.
     *
     */
    private lateinit var navHostController: NavHostController

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MobileProgrammingTheme {
                navHostController = rememberNavController()
                SetupNavGraph(navHostController = navHostController)

            }
        }


    }


}
