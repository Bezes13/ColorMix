package com.games.colormix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.games.colormix.manager.MainViewModelFactory
import com.example.whattowatch.manager.SharedPreferencesManager
import com.games.colormix.manager.StartViewModelFactory
import com.games.colormix.navigation.AppNavHost
import com.games.colormix.start.StartViewModel
import com.games.colormix.ui.theme.ColorMixTheme
import kotlinx.coroutines.Dispatchers

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPreferencesManager = SharedPreferencesManager(this)
        val ioDispatcher = Dispatchers.IO
        val mainViewModel: MainViewModel by viewModels {
            MainViewModelFactory(sharedPreferencesManager, ioDispatcher)
        }
        val startViewModel: StartViewModel by viewModels {
            StartViewModelFactory(sharedPreferencesManager, ioDispatcher)
        }
        setContent {
            ColorMixTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    AppNavHost(navController = rememberNavController(), main = mainViewModel, start = startViewModel)
                }
            }
        }
    }
}