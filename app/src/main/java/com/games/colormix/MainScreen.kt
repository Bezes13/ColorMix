package com.games.colormix

import Explosion
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
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
import androidx.lifecycle.viewmodel.compose.viewModel

val FieldSize = 50.dp
val VerticalPadding = 5.dp

@Composable
fun MainScreen(mainViewModel: MainViewModel = viewModel()) {
    val viewState: MainViewState by mainViewModel.viewState.collectAsState()
    MainScreenContent(
        viewState.gameField,
        mainViewModel::sendEvent,
        viewState.animationAt
    )
}

@Composable
fun MainScreenContent(
    gameField: List<List<ColorField?>>,
    eventListener: (MainViewEvent) -> Unit,
    animateAt: Animation?
) {
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
        Box (modifier = Modifier.align(Alignment.CenterHorizontally)){
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
private fun AnimationGrid(
    gameField: List<List<ColorField?>>,
    animateAt: Animation?,
    eventListener: (MainViewEvent) -> Unit,
) {
    val progress by animateFloatAsState(
        animationSpec = TweenSpec(500),
        targetValue = if(animateAt != null) 1f else 0f,
        label = "offset",
        finishedListener = {
            eventListener(MainViewEvent.SetAnimateAt(null))}
    )
    Box {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            for (i in gameField.indices) {
                Column(verticalArrangement = Arrangement.spacedBy(VerticalPadding)) {
                    for (j in gameField[i].indices) {
                        Box(
                            modifier = Modifier.size(FieldSize),
                            contentAlignment = Alignment.Center
                        ) {
                            if (Pair(i, j) == animateAt?.pos) {
                                Explosion(progress = progress, animateAt.color)
                                println(progress)
                            }
                        }

                    }
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
    data class Dialog(val info: String) : MainViewDialog()
    data object None : MainViewDialog()
}

@Composable
@Preview
fun PreviewMainScreen() {
    MainScreenContent(
        (0 until 4).map { arrayOfNulls<ColorField?>(4).toList() }, {}, null
    )
}
