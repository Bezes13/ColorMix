package com.games.colormix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.whattowatch.manager.MainViewModelFactory
import com.example.whattowatch.manager.SharedPreferencesManager
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
        setContent {
            ColorMixTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    MainScreen(mainViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ColorMixTheme {
        Greeting("Android")
    }
}