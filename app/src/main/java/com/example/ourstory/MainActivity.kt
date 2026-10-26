package com.example.ourstory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ourstory.screen.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "splash"
            ) {

                // Splash Screen
                composable("splash") {
                    SplashScreen(
                        onSplashFinished = {
                            navController.navigate("welcome") {
                                popUpTo("splash") {
                                    inclusive = true
                                }
                            }
                        }
                    )
                }

                // Welcome Screen
                composable("welcome") {
                    WelcomeScreen(
                        onLetsBeginClick = {
                            navController.navigate("home")
                        }
                    )
                }

                // Home Screen
                composable("home") {
                    EntryScreen(
                        onMemoriesClick = {
                            navController.navigate("memories")
                        },
                        onLettersClick = {
                            navController.navigate("letter")
                        },
                        onSongsClick = {
                            navController.navigate("songs")
                        },
                        onDreamsClick = {
                            navController.navigate("dreams")
                        },
                        onPromiseClick = {
                            navController.navigate("promise")
                        }
                    )
                }

                // Memories
                composable("memories") {
                    MemoriesScreen(
                        onBackClick = {
                            navController.popBackStack()
                        }
                    )
                }

                // Letter
                composable("letter") {
                    LetterScreen(
                        onBackClick = {
                            navController.popBackStack()
                        }
                    )
                }

                // Songs
                composable("songs") {
                    SongsScreen(
                        onBackClick = {
                            navController.popBackStack()
                        }
                    )
                }

                // Future Dreams
                composable("dreams") {
                    FutureDreamsScreen(
                        onBackClick = {
                            navController.popBackStack()
                        }
                    )
                }

                // Promise
                composable("promise") {
                    PromiseScreen(
                        onBackClick = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}