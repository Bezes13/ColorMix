package com.games.colormix.screens.levelselection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.games.colormix.R
import com.games.colormix.constants.BackgroundBlocks
import com.games.colormix.constants.ItemRowCount
import com.games.colormix.constants.Padding
import com.games.colormix.data.ColorField
import com.games.colormix.data.randomBlock
import com.games.colormix.game.LevelLists
import com.games.colormix.navigation.Screen
import com.games.colormix.screens.start.Background
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
    val width = LocalConfiguration.current.screenWidthDp.dp
    var id = 0
    val background by remember {
        mutableStateOf((1 until BackgroundBlocks).map {
            Array(BackgroundBlocks * 2) { ColorField(id++, randomBlock()) }
                .toList()
        })
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    MyText(
                        stringResource(R.string.level_selection),
                        fontSize = MaterialTheme.typography.headlineLarge.fontSize
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navigate(Screen.HOME.name) }) {
                        Icon(Icons.Filled.ArrowBack, stringResource(R.string.menu))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Background(fieldSize = width / BackgroundBlocks, backGround = background)
            LazyColumn(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(it)
                    .background(Color.Transparent)
            ) {
                LevelLists.levelList.chunked(ItemRowCount).forEachIndexed { rIndex, levels ->
                    item {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = Padding.XL)
                        ) {
                            levels.forEachIndexed { cIndex, _ ->
                                LevelSelectionField(
                                    Pair(rIndex, cIndex+1),
                                    currentLevel,
                                    width / (ItemRowCount + 1),
                                    navigate,
                                    getPoints
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
    LevelSelectionScreen(currentLevel = 4, {}, { 5789 })
}