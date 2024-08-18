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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.games.colormix.game.LevelLists
import com.games.colormix.navigation.Screen
import com.games.colormix.utils.MyText

@Composable
fun LevelSelectionScreen(
    navigate: (String) -> Unit,
    lsViewModel: LevelSelectionViewModel = hiltViewModel()
) {
    LevelSelectionScreen(lsViewModel.getCurrentMaxLevel(), navigate, lsViewModel::getCurrentPoints)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LevelSelectionScreen(currentLevel: Int, navigate: (String) -> Unit, getPoints: (Int) -> Int) {
    Scaffold(
        topBar = { TopAppBar(
            title = { MyText(stringResource(R.string.level_selection),  fontSize = MaterialTheme.typography.headlineLarge.fontSize)},
            navigationIcon = {
                IconButton(onClick = { navigate(Screen.HOME.name) }) {
                    Icon(Icons.Filled.ArrowBack, stringResource(R.string.menu))
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
        )
        }
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(it)
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            for (i in 0..LevelLists.levelList.size / 3) {
                item {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ) {
                        for (j in 1..3) {
                            val level = (i * 3 + j)
                            if (level <= LevelLists.levelList.size) {
                                val mod =
                                    if (level <= currentLevel + 1) Modifier.clickable {
                                        navigate(
                                            Screen.Main.name + "/${level}"
                                        )
                                    } else Modifier
                                Card(
                                    modifier = mod.size(110.dp),
                                    border = BorderStroke(
                                        3.dp,
                                        MaterialTheme.colorScheme.secondary.copy(alpha = if (level <= currentLevel + 1) 1f else 0.5f)
                                    ),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(
                                            alpha = if (level <= currentLevel + 1) 1f else 0.5f
                                        ),
                                        contentColor = MaterialTheme.colorScheme.secondary.copy(
                                            alpha = if (level <= currentLevel + 1) 1f else 0.5f
                                        )
                                    )
                                ) {
                                    Box(
                                        contentAlignment = Alignment.TopCenter,
                                        modifier = Modifier.fillMaxSize()
                                    ) {
                                        Column(modifier = Modifier.fillMaxWidth()) {
                                            MyText(
                                                text = level.toString(),
                                                fontSize = 40.sp,
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier.fillMaxWidth()
                                            )
                                            Divider(
                                                thickness = 3.dp,
                                                color = MaterialTheme.colorScheme.secondary.copy(
                                                    alpha = if (level <= currentLevel + 1) 1f else 0.5f
                                                ),
                                                modifier = Modifier.fillMaxWidth()
                                            )
                                            MyText(
                                                text = getPoints(level - 1).toString(),
                                                fontSize = 30.sp,
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier.fillMaxWidth()
                                            )
                                        }

                                        if (level <= currentLevel) {
                                            Icon(
                                                imageVector = Icons.Default.Check,
                                                contentDescription = stringResource(
                                                    R.string.completed
                                                ),
                                                modifier = Modifier.size(90.dp),
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
        }
    }

}

@Preview
@Composable
fun LevelSelectionPreview() {
    LevelSelectionScreen(currentLevel = 4, {}, { 5789 })
}