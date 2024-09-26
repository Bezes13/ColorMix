package com.games.colormix.screens.main

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.games.colormix.R
import com.games.colormix.constants.LEVEL_SIZE_X
import com.games.colormix.constants.RUBIK_GAIN_MULTI_BLOCK
import com.games.colormix.constants.Padding
import com.games.colormix.constants.TutorialString
import com.games.colormix.constants.infoCardHeightMultiplier
import com.games.colormix.data.Animation
import com.games.colormix.data.ColorField
import com.games.colormix.data.LevelInfo
import com.games.colormix.game.LevelLists
import com.games.colormix.utils.hackClassLoader
import com.games.colormix.navigation.Screen
import com.games.colormix.screens.main.components.animations.AnimationGrid
import com.games.colormix.screens.main.components.animations.GainPowerUp
import com.games.colormix.screens.main.components.animations.LazyAnimatedColumn
import com.games.colormix.screens.main.components.BorderedBox
import com.games.colormix.screens.main.components.DraggableItem
import com.games.colormix.screens.main.components.Field
import com.games.colormix.screens.main.components.LevelDoneDialog
import com.games.colormix.screens.main.components.LevelInfoCard
import com.games.colormix.screens.main.components.MovesInfo
import com.games.colormix.screens.main.components.QuestInfo
import com.games.colormix.screens.main.components.TopAppBar
import com.games.colormix.screens.start.tutorial.PowerUpTutorial
import com.games.colormix.screens.start.tutorial.QuestTutorial
import com.games.colormix.utils.MyText

@Composable
fun MainScreen(navigate: (String) -> Unit, mainViewModel: MainViewModel = hiltViewModel()) {
    val viewState: MainViewState by mainViewModel.viewState.collectAsState()
    if (viewState.currentLevel.level > LevelLists.levelList.size) {
        navigate(Screen.LEVEL_SELECTION.name)
    }
    val sharedPreferences: SharedPreferences = LocalContext.current.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
    if (sharedPreferences.getInt(TutorialString, 0) == 0) {
        mainViewModel.sendEvent(MainViewEvent.SetDialog(MainViewDialog.QuestTutorial))
        val editor = sharedPreferences.edit()
        editor.putInt(TutorialString, 1)
        editor.apply()
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
        viewState.rubikCount,
        viewState.blocksAcc
    )
}

@Composable
fun MainScreenContent(
    navigate: (String) -> Unit,
    gameField: List<List<ColorField>>,
    eventListener: (MainViewEvent) -> Unit,
    animateAt: List<Animation>,
    currentLevel: LevelInfo,
    dialog: MainViewDialog,
    points: Int,
    bombCount: Int,
    rubikCount: Int,
    blocksAcc: Int
) {
    val width = LocalConfiguration.current.screenWidthDp.dp
    val height = LocalConfiguration.current.screenHeightDp.dp
    val fieldSize = (width / (LEVEL_SIZE_X + 1))
    val infoCardsHeight = (height / infoCardHeightMultiplier)
    val levelTextSize = with(LocalDensity.current) { fieldSize.toSp() }
    val infoTextSize = levelTextSize / 2
    val sharedPreferences: SharedPreferences = LocalContext.current.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
    var simpleDesign by remember { mutableStateOf(sharedPreferences.getBoolean("Design", false)) }
    val animatedPoints by animateIntAsState(
        animationSpec = TweenSpec(500),
        targetValue = points,
        label = "points",
        finishedListener = {}
    )

    val endless = currentLevel.level == 0

    when (dialog) {
        is MainViewDialog.LevelComplete -> LevelDoneDialog(
            R.string.next_level,
            R.string.level_complete,
            stringResource(id = R.string.level_complete_body, currentLevel.level),
            dialog
        ) {
            eventListener(
                MainViewEvent.NextLevel
            )
        }

        MainViewDialog.LevelFailed -> LevelDoneDialog(
            R.string.retry,
            R.string.level_failed,
            stringResource(id = R.string.level_failed_body)
        )
        {
            eventListener(
                MainViewEvent.Retry
            )
        }

        MainViewDialog.NoMovesAvailable -> LevelDoneDialog(
            R.string.retry,
            R.string.no_more_moves,
            stringResource(id = R.string.no_more_moves_body)
        )
        {
            eventListener(
                MainViewEvent.Retry
            )
        }

        MainViewDialog.None -> {}
        MainViewDialog.PowerUpTutorial -> {
            PowerUpTutorial {
                eventListener(MainViewEvent.SetDialog(MainViewDialog.None))
            }
        }

        MainViewDialog.QuestTutorial -> {
            QuestTutorial(fieldSize) {
                eventListener(MainViewEvent.SetDialog(MainViewDialog.PowerUpTutorial))
            }
        }
    }
    val sizeMultiplier = 1.5f
    val questInfoMultiplier = 0.7f
    val pointDigits = 6
    Box {
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = stringResource(R.string.specialtype),
            alignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight
        )
    Scaffold(
        topBar = { TopAppBar(eventListener, navigate) },
        containerColor = Color.Transparent
    ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(Padding.M),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(Color.Transparent),
            ) {
                Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {

                    LevelInfoCard(modifier = Modifier.height(fieldSize * sizeMultiplier)) {
                        MyText(
                            if (endless) stringResource(id = R.string.endless_mode) else stringResource(
                                id = R.string.level,
                                currentLevel.level
                            ),
                            fontSize = levelTextSize,
                            style = TextStyle(color = MaterialTheme.colorScheme.primary),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                    Row (verticalAlignment = Alignment.CenterVertically){
                        Switch(checked = simpleDesign , onCheckedChange = { checked ->
                            simpleDesign = checked
                            val editor = sharedPreferences.edit()
                            editor.putBoolean("Design", simpleDesign)
                            editor.apply()
                        })
                    }
                }

                BorderedBox(modifier = Modifier.padding(5.dp)) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Column {
                            if (!endless) {
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(infoCardsHeight)
                                ) {
                                    MovesInfo(currentLevel, infoTextSize)
                                    QuestInfo(currentLevel, fieldSize * questInfoMultiplier)
                                }
                            }
                            Row(
                                modifier = Modifier
                                    .height(infoCardsHeight / 2)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                LevelInfoCard(modifier = Modifier.height(fieldSize)) {
                                    MyText(
                                        text = animatedPoints.toString().padStart(pointDigits, '0'),
                                        fontSize = with(LocalDensity.current) { (fieldSize / sizeMultiplier).toSp() },
                                        modifier = Modifier.padding(
                                            vertical = Padding.M,
                                            horizontal = Padding.XL
                                        )
                                    )
                                }
                                Row {
                                    DraggableItem(
                                        stringResource(R.string.bomb_item),
                                        bombCount,
                                        R.drawable.meteor,
                                        fieldSize
                                    )
                                    DraggableItem(
                                        label = stringResource(R.string.rubik_item),
                                        count = rubikCount,
                                        R.drawable.gun,
                                        fieldSize,
                                        blocksAcc.toFloat() / RUBIK_GAIN_MULTI_BLOCK.toFloat()
                                    )
                                }

                            }
                        }

                        Box(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                horizontalArrangement = if (simpleDesign) Arrangement.spacedBy(Padding.M) else Arrangement.Center,
                                modifier = Modifier.padding(Padding.L)
                            ) {
                                gameField.forEachIndexed { cIndex, column ->
                                    LazyAnimatedColumn(
                                        items = column,
                                        keyProvider = { item -> item.toString() },
                                        lazyModifier = { Modifier.animateItem() },
                                    ) { _, item ->
                                        Field(
                                            item,
                                            if (simpleDesign) fieldSize*0.95f else fieldSize,
                                            Pair(cIndex, column.indexOf(item)),
                                            eventListener,
                                            simpleDesign,
                                            Modifier
                                        )
                                    }
                                }
                            }
                            AnimationGrid(gameField, animateAt, fieldSize, eventListener)
                            GainPowerUp(rubikCount, R.drawable.gun)
                            GainPowerUp(bombCount, R.drawable.meteor)
                        }
                    }
                }
            }
        }
    }
}

sealed class MainViewDialog {
    data class LevelComplete(
        val info: String,
        val moves: Int,
        val bombCount: Int,
        val rubikCount: Int
    ) : MainViewDialog()
    data object LevelFailed : MainViewDialog()
    data object QuestTutorial : MainViewDialog()
    data object PowerUpTutorial : MainViewDialog()
    data object None : MainViewDialog()
    data object NoMovesAvailable : MainViewDialog()
}

@Composable
@Preview
fun PreviewMainScreen() {
    hackClassLoader()
    MainScreenContent(
        {},
        (0 until 4).map { arrayOf<ColorField>().toList() },
        {},
        listOf(),
        LevelInfo(),
        MainViewDialog.None, 66666, 4, 7, 35
    )
}
