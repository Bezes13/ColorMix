package com.games.colormix

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.games.colormix.data.Animation
import com.games.colormix.data.ColorField
import com.games.colormix.data.SpecialType
import com.games.colormix.data.startColors

val FieldSize = 45.dp
val VerticalPadding = 5.dp

@Composable
fun MainScreen(mainViewModel: MainViewModel = viewModel()) {
    val viewState: MainViewState by mainViewModel.viewState.collectAsState()
    MainScreenContent(
        viewState.gameField,
        mainViewModel::sendEvent,
        viewState.animationAt,
        viewState.currentLevel,
        viewState.dialog
    )
}

@Composable
fun MainScreenContent(
    gameField: List<List<ColorField?>>,
    eventListener: (MainViewEvent) -> Unit,
    animateAt: Animation?,
    currentLevel: LevelInfo,
    dialog: MainViewDialog
) {
    when(dialog){
        is MainViewDialog.LevelComplete -> LevelCompleteDialog ({
            eventListener(
                MainViewEvent.SetDialog(
                    MainViewDialog.None
                )
            )})
        {
            eventListener(
                MainViewEvent.NextLevel
            )}

        is MainViewDialog.LevelFailed -> LevelFailedDialog ({
            eventListener(
                MainViewEvent.SetDialog(
                    MainViewDialog.None
                )
            )})
        {
            eventListener(
                MainViewEvent.Retry
            )}

        is MainViewDialog.None -> {}
    }
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
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {
            Card(modifier = Modifier
                .weight(1f)
                .fillMaxSize()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                ) {
                    Text(text = "Moves:")
                    Text(text = currentLevel.moves.toString())
                }

            }
            Card(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Column {
                        currentLevel.quests.forEach { quest ->
                            Row(
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxSize()
                            ) {
                                Text(text = quest.amount.toString())
                                Box {
                                    Row (horizontalArrangement = Arrangement.spacedBy(2.dp)){
                                        QuestObject(quest = quest)
                                        if (quest.specialType == SpecialType.None) {
                                            QuestObject(quest = quest)
                                        }
                                    }

                                }


                            }
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
            ) {
                for (i in gameField.indices) {
                    GameColumn(gameField[i], i, eventListener)
                }
            }
            AnimationGrid(gameField, animateAt, eventListener)
        }
    }
}

@Composable
fun LevelCompleteDialog(dismiss: ()-> Unit, nextLevel: ()-> Unit) {
    Dialog(onDismissRequest =  dismiss ) {
        Card {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Congrats")
                Button(onClick = nextLevel) {
                    Text(text = "Next Level")
                }
            }
        }
    }
}

@Composable
fun LevelFailedDialog(dismiss: ()-> Unit, retry: ()-> Unit) {
    Dialog(onDismissRequest =  dismiss ) {
        Card {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(10.dp)) {
                Text(text = "Failed...")
                Button(onClick =  retry ) {
                    Text(text = "Retry")
                }
            }

        }

    }
}

@Composable
fun GameColumn(
    colorFields: List<ColorField?>, column: Int, eventListener: (MainViewEvent) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(VerticalPadding)) {
        for (i in colorFields.indices) {
            Field(colorFields[i], Pair(column, i), eventListener)
        }
    }
}

sealed class MainViewDialog {
    data class LevelComplete(val info: String) : MainViewDialog()
    data object LevelFailed: MainViewDialog()
    data object None : MainViewDialog()
}

@Composable
@Preview
fun PreviewMainScreen() {
    MainScreenContent(
        (0 until 4).map { arrayOfNulls<ColorField?>(4).toList() }, {}, null, LevelData.LEVELS[8],MainViewDialog.None
    )
}
