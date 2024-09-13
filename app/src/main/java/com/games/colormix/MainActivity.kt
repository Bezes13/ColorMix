package com.games.colormix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.games.colormix.navigation.AppNavHost
import com.games.colormix.navigation.Screen
import com.games.colormix.ui.theme.ColorMixTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val auth: FirebaseAuth = FirebaseAuth.getInstance()

        val startScreen = if (auth.currentUser == null) Screen.Auth else Screen.HOME
        setContent {
            ColorMixTheme {
                FirebaseApp.initializeApp(this)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    AppNavHost(
                        navController = rememberNavController(),
                        startDestination = startScreen.name
                    )
                }
            }
        }
    }
}