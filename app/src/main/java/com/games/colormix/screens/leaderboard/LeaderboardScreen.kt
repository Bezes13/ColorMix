package com.games.colormix.screens.leaderboard

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Leaderboard
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.games.colormix.R
import com.games.colormix.constants.BackgroundBlocks
import com.games.colormix.constants.CardAlpha
import com.games.colormix.constants.Padding
import com.games.colormix.data.ColorField
import com.games.colormix.data.randomBlock
import com.games.colormix.model.BoardScore
import com.games.colormix.navigation.Screen
import com.games.colormix.screens.start.Background
import com.games.colormix.utils.MyText

@Composable
fun LeaderboardScreen(
    navigate: (String) -> Unit,
    viewModel: LeaderboardViewModel = hiltViewModel()
) {
    val viewState: LeaderBordViewState by viewModel.viewState.collectAsState()
    LeaderboardScreen(
        isLoading = viewState.isLoading,
        navigate = navigate,
        leaderboard = viewState.leaderboard,
        leaderboardAllLevel = viewState.leaderboardLevelCompleted,
        fetchData = viewModel::fetchLeaderboard
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeaderboardScreen(
    isLoading: Boolean,
    leaderboard: List<BoardScore>,
    leaderboardAllLevel: List<BoardScore>,
    navigate: (String) -> Unit,
    fetchData: () -> Unit
) {
    val width = LocalConfiguration.current.screenWidthDp.dp
    var id = 0
    val background by remember {
        mutableStateOf((1 until BackgroundBlocks).map {
            Array(BackgroundBlocks * 2) { ColorField(id++, randomBlock()) }
                .toList()
        })
    }
    var selectedBoard by remember { mutableStateOf(0) }
    val simpleDesign =
        LocalContext.current.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
            .getBoolean("Design", false)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    MyText(
                        stringResource(R.string.leaderboard),
                        fontSize = MaterialTheme.typography.headlineLarge.fontSize
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navigate(Screen.HOME.name) }) {
                        Icon(Icons.Filled.ArrowBack, stringResource(R.string.menu))
                    }
                },
                actions = {
                    IconButton(onClick = { fetchData() }) {
                        Icon(Icons.Filled.Refresh, stringResource(R.string.reload))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(
                        alpha = CardAlpha
                    )
                )
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Background(
                fieldSize = width / BackgroundBlocks,
                backGround = background,
                simpleDesign = simpleDesign
            )
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                verticalArrangement = if (isLoading) Arrangement.Center else Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        TabRow(
                            selectedTabIndex = selectedBoard,
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        ) {
                            Tab(text = { MyText(stringResource(R.string.points)) },
                                selected = selectedBoard == 0,
                                onClick = { selectedBoard = 0 },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = null
                                    )
                                }
                            )
                            Tab(text = { MyText(stringResource(R.string.completed_level)) },
                                selected = selectedBoard == 1,
                                onClick = { selectedBoard = 1 },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Leaderboard,
                                        contentDescription = null
                                    )
                                }
                            )

                        }
                        Spacer(modifier = Modifier.size(Padding.XL))
                        if (isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.width(64.dp),
                                color = MaterialTheme.colorScheme.secondary,
                                trackColor = MaterialTheme.colorScheme.surfaceVariant,
                            )
                        } else {
                        when (selectedBoard) {
                            0 -> LeaderBoard(leaderboard, stringResource(R.string.points))
                            1 -> LeaderBoard(leaderboardAllLevel, stringResource(R.string.levels))
                        }
                    }
                }

            }
        }
    }
}

@Preview
@Composable
fun LeaderboardScreenPreview() {
    LeaderboardScreen(true, listOf(), listOf(), {}, {})
}

@Preview
@Composable
fun LeaderboardScreenPreview1() {
    LeaderboardScreen(false, listOf(
        BoardScore("Alexander", 1238912389),
        BoardScore("Annalena", 1289),
        BoardScore("Fred", 1238912389),
    ), listOf(), {}, {})
}