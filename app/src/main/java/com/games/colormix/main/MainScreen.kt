package com.games.colormix.main

import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.games.colormix.R
import com.games.colormix.data.Animation
import com.games.colormix.data.ColorField
import com.games.colormix.game.AnimationGrid
import com.games.colormix.game.BorderedBox
import com.games.colormix.game.DraggableItem
import com.games.colormix.game.Field
import com.games.colormix.game.LevelData
import com.games.colormix.game.LevelDoneDialog
import com.games.colormix.game.LevelInfo
import com.games.colormix.game.LevelInfoCard
import com.games.colormix.game.MovesInfo
import com.games.colormix.game.QuestInfo
import com.games.colormix.navigation.Screen

val FieldSize = 40.dp
val VerticalPadding = 5.dp

@Composable
fun MainScreen(navigate: (String) -> Unit, mainViewModel: MainViewModel = hiltViewModel()) {
    val viewState: MainViewState by mainViewModel.viewState.collectAsState()
    if (viewState.currentLevel.level > LevelData.LEVELS.size) {
        navigate(Screen.LEVEL_SELECTION.name)
    }
    MainScreenContent(
        navigate,
        viewState.gameField,
        mainViewModel::sendEvent,
        viewState.animationAt,
        viewState.currentLevel,
        viewState.dialog,
        viewState.points,
        viewState.bombCount,
        viewState.rubikCount
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreenContent(
    navigate: (String) -> Unit,
    gameField: List<List<ColorField?>>,
    eventListener: (MainViewEvent) -> Unit,
    animateAt: List<Animation>,
    currentLevel: LevelInfo,
    dialog: MainViewDialog,
    points: Int,
    bombCount: Int,
    rubikCount: Int
) {
    val animatedPoints by animateIntAsState(
        animationSpec = TweenSpec(500),
        targetValue = points,
        label = "points",
        finishedListener = {}
    )

    when (dialog) {
        is MainViewDialog.LevelComplete -> LevelDoneDialog(
            R.string.next_level,
            R.string.level_complete,
            stringResource(id = R.string.level_complete_body, currentLevel.level)
        ) {
            eventListener(
                MainViewEvent.NextLevel
            )
        }

        is MainViewDialog.LevelFailed -> LevelDoneDialog(
            R.string.retry,
            R.string.level_failed,
            stringResource(id = R.string.level_failed_body)
        )
        {
            eventListener(
                MainViewEvent.Retry
            )
        }

        is MainViewDialog.NoMovesAvailable -> LevelDoneDialog(
            R.string.retry,
            R.string.no_more_moves,
            stringResource(id = R.string.no_more_moves_body)
        )
        {
            eventListener(
                MainViewEvent.Retry
            )
        }

        is MainViewDialog.None -> {}
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box {}
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 60.sp,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.primary,
                    textDecoration = TextDecoration.Underline
                ),
                textAlign = TextAlign.Center
            )
            IconButton(onClick = { navigate(Screen.HOME.name) }) {
                Icon(Icons.Default.Menu, stringResource(R.string.menu))
            }
        }
        LevelInfoCard {
            Text(
                stringResource(id = R.string.level, currentLevel.level),
                fontSize = 30.sp,
                style = TextStyle(color = MaterialTheme.colorScheme.primary),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp)
            )
        }
        BorderedBox {
            Column(
                verticalArrangement = Arrangement.spacedBy(100.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth(0.95f)
                            .height(80.dp)
                    ) {
                        MovesInfo(currentLevel)
                        QuestInfo(currentLevel)
                    }
                    Row(
                        modifier = Modifier.height(40.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        LevelInfoCard {
                            Text(
                                text = animatedPoints.toString(),
                                fontSize = 25.sp,
                                modifier = Modifier.padding(vertical = 5.dp, horizontal = 15.dp)
                            )
                        }
                        DraggableItem("bomb", bombCount, R.drawable.bomb )
                        DraggableItem(label = "rubik", count = rubikCount, R.drawable.rubik)
                    }
                }

                Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        modifier = Modifier.padding(10.dp)
                    ) {
                        for (i in gameField.indices) {
                            Column(verticalArrangement = Arrangement.spacedBy(VerticalPadding)) {
                                for (j in gameField[i].indices) {
                                    Field(gameField[i][j], Pair(i, j), eventListener)
                                }
                            }
                        }
                    }
                    AnimationGrid(gameField, animateAt, eventListener)
                }
            }
        }
    }
}

sealed class MainViewDialog {
    data class LevelComplete(val info: String) : MainViewDialog()
    data object LevelFailed : MainViewDialog()
    data object None : MainViewDialog()
    data object NoMovesAvailable : MainViewDialog()
}

@Composable
@Preview
fun PreviewMainScreen() {
    MainScreenContent(
        {},
        (0 until 4).map { arrayOfNulls<ColorField?>(4).toList() },
        {},
        listOf(),
        LevelData.LEVELS[8],
        MainViewDialog.None, 66666, 4,7
    )
}
