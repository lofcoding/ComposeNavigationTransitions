package com.example.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "screen_a") {
                    composable(
                        route = "screen_a"
                    ) {
                        ScreenA(
                            navigateToB = {
                                navController.navigate("screen_b")
                            }
                        )
                    }

                    composable(
                        route = "screen_b"
                    ) {
                        ScreenB(
                            navigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}







