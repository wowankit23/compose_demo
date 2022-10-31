package com.mp.compose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 * to give dagger hilt info about our app
 * so it will have access to the app context if needed for the dependencies
 */
@HiltAndroidApp
class MyApplication: Application(){
    override fun onCreate() {
        super.onCreate()
    }
}
