package com.games.colormix.start

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.games.colormix.R
import com.games.colormix.data.startColors
import com.games.colormix.navigation.Screen

@Composable
fun StartScreen(navController: NavController, startViewModel: StartViewModel = viewModel()) {
    StartScreen(
        navController::navigate,
        startViewModel::getNextLevel
    )
}

@Composable
fun StartScreen(navigate: (String)-> Unit, getNextLevel: () -> Int){
    Column(
        verticalArrangement = Arrangement.spacedBy(30.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            stringResource(id = R.string.app_name),
            fontSize = 60.sp,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = startColors
                )
            ),

            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        println(getNextLevel())
        Button(onClick = { navigate(Screen.Main.name+"/${getNextLevel()}") }) {
            Text(text = stringResource(id = R.string.play))
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.level_selection))
        }
    }
}