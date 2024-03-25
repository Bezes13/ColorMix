package com.games.colormix.start

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.games.colormix.R
import com.games.colormix.data.startColor
import com.games.colormix.navigation.Screen

@Composable
fun StartScreen(navigate: (String) -> Unit, startViewModel: StartViewModel = hiltViewModel()) {
    StartScreen(
        navigate,
        startViewModel::getCurrentMaxLevel
    )
}

@Composable
fun StartScreen(
    navigate: (String) -> Unit,
    getCurrentLevel: () -> Int
) {
    val backGround by remember {
        mutableStateOf((0 until 20).map {
            Array(10) { startColor() }
                .toList()
        })
    }
    val activity = (LocalContext.current as? Activity)
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            backGround.forEach { row ->
                Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    row.forEach { block ->
                        Card(
                            modifier = Modifier.size(45.dp),
                            colors = CardDefaults.cardColors(containerColor = block)
                        ) {
                        }
                    }
                }
            }
        }

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .weight(0.4f)
                    .padding(vertical = 60.dp)
            ) {
                Card(
                    modifier = Modifier.wrapContentSize(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                ) {
                    Text(
                        stringResource(id = R.string.app_name),
                        fontSize = 80.sp,
                        style = TextStyle(color = MaterialTheme.colorScheme.primary),
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(0.8f)
            ) {
                MenuButton(R.string.play) { navigate(Screen.Main.name + "/${getCurrentLevel()}") }
                MenuButton(R.string.level_selection) { navigate(Screen.LEVELSELECTION.name) }
                MenuButton(R.string.quit) { activity?.finish() }
            }
        }
    }
}

@Composable
private fun MenuButton(textId: Int, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth(0.7f),
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colorScheme.secondary,
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        onClick = onClick
    ) {
        Text(text = stringResource(id = textId), fontSize = 30.sp, textAlign = TextAlign.Center)
    }
}