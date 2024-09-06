package com.example.hardwarestore

import android.animation.ObjectAnimator
import android.app.ActionBar
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.doOnEnd
import androidx.core.app.TaskStackBuilder.SupportParentable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.hardwarestore.NavGraphs.RootNavigationGraph
import com.example.hardwarestore.Screen.HomePage
import com.example.hardwarestore.Screen.LoadingAnimation
import com.example.hardwarestore.Screen.Settings
import com.example.hardwarestore.ui.theme.HardwareStoreTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>() //splash screen view model
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
//hide action bar
        actionBar?.hide()
        //splash screen
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.isReady.value
            }
            //on exit of splash screen
            setOnExitAnimationListener { screen ->
                val zoomX = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_X,
                    0.85f,
                    0.0f
                )
                zoomX.interpolator = OvershootInterpolator()
                zoomX.duration = 500L
                zoomX.doOnEnd { screen.remove() }


                val zoomY = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_Y,
                    0.85f,
                    0.0f
                )
                zoomY.interpolator = OvershootInterpolator()
                zoomY.duration = 500L
                zoomY.doOnEnd { screen.remove() }

                zoomX.start()
                zoomY.start()


            }

            setContent {
                var darkTheme by remember { mutableStateOf(false) }
                HardwareStoreTheme(/*darkTheme = darkTheme*/){
                    //dark mode button
                   // Settings(darkTheme = darkTheme, onThemeUpdated = {darkTheme=!darkTheme})
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {

                        RootNavigationGraph(navController = rememberNavController())

                            


                    }
                }
            }
        }
    }

}