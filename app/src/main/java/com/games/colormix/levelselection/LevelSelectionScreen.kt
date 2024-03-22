package com.games.colormix.levelselection

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.games.colormix.R
import com.games.colormix.game.LevelData
import com.games.colormix.navigation.Screen

@Composable
fun LevelSelectionScreen(
    navigate: (String) -> Unit,
    lsViewModel: LevelSelectionViewModel = hiltViewModel()
) {
    LevelSelectionScreen(lsViewModel.getCurrentMaxLevel(), navigate, lsViewModel::getCurrentPoints)
}

@Composable
fun LevelSelectionScreen(currentLevel: Int, navigate: (String) -> Unit, getPoints: (Int)-> Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        for (i in 0..LevelData.LEVELS.size / 3) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                for (j in 1..3) {
                    val level = (i * 3 + j)
                    if (level > LevelData.LEVELS.size) {
                        return
                    }
                    Card(
                        modifier = Modifier
                            .size(110.dp)
                            .clickable { navigate(Screen.Main.name + "/${level - 1}") },
                        border = BorderStroke(3.dp, MaterialTheme.colorScheme.secondary),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Column {
                                Text(text = level.toString(), fontSize = 40.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                                Divider(thickness = 3.dp, color = MaterialTheme.colorScheme.secondary)
                                Text(text = getPoints(level-1).toString(), fontSize = 40.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                            }

                            if (level <= currentLevel) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = stringResource(
                                        R.string.completed
                                    ),
                                    modifier = Modifier.size(50.dp),
                                    tint = Color.Green
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun LevelSelectionPreview() {
    LevelSelectionScreen(currentLevel = 4, {}, {5})
}