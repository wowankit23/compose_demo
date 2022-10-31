package com.mp.compose

import android.annotation.SuppressLint
import android.graphics.Insets.add
import android.os.Build
import android.os.Build.VERSION.SDK_INT

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.delay

/**
 * Function SplashScreen contains the splash screen image,
 * and specifies how long it will be displayed for.
 */
@SuppressLint("NotConstructor")
@Composable
fun SplashScreen(navController: NavController
) {
    val context = LocalContext.current
    val dataStore = DataStoreRepository(context)

    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1.25f,
        )
        // Customise the delay time
        delay(2000L)

        dataStore.readOnBoardingState().collect{
            if (it) {
                navController.navigate(Screen.Home.route)

            }else{

                navController.navigate(Screen.Login.route)
            }
        }
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(colorResource(id = R.color.purple_200))
    ) {
        Image(
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Logo",
            colorFilter = ColorFilter.tint(colorResource(id = R.color.white)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 120.dp)
        )
        BubbleAnimation()
    }
}

/**
 * Function BubbleAnimation contains the bubble animation that will be used in the splash screen.
 * Using the Coil API, this is how the bubble animation will be displayed.
 * It also specifies the size of the bubble animation.
 */
@ExperimentalCoilApi
@Composable
fun BubbleAnimation() {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            /**
             * If the SDK is greater than or equal to version 28 then image decoder will be used.
             * Otherwise, it will use GIF decoder.
             */
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context).data(data = R.drawable.bubble_animation)
                .apply(block = {
                }).build(), imageLoader = imageLoader
        ),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(420.dp)
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SplashScreenPreview(){
    SplashScreen(rememberNavController())
}
