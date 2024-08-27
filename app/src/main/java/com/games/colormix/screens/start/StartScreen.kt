package com.games.colormix.screens.start

import android.app.Activity
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.games.colormix.R
import com.games.colormix.constants.BackgroundBlocks
import com.games.colormix.constants.BorderWidthLarge
import com.games.colormix.constants.MenuButtonShape
import com.games.colormix.constants.Padding
import com.games.colormix.data.ColorField
import com.games.colormix.utils.hackClassLoader
import com.games.colormix.navigation.Screen
import com.games.colormix.screens.start.tutorial.PowerUpTutorial
import com.games.colormix.screens.start.tutorial.QuestTutorial
import com.games.colormix.utils.MyText

@Composable
fun StartScreen(navigate: (String) -> Unit, startViewModel: StartViewModel = hiltViewModel()) {
    val viewState: StartViewState by startViewModel.viewState.collectAsState()
    val width = LocalConfiguration.current.screenWidthDp.dp
    val height = LocalConfiguration.current.screenHeightDp.dp
    val fieldSize = (width / BackgroundBlocks)

    LaunchedEffect(Unit) {
        val backgroundSize = IntSize(((width / fieldSize) - 1).toInt(), ((height / fieldSize)).toInt())
        startViewModel.backgroundSize = backgroundSize
        startViewModel.fillBackground()
    }
    StartScreen(
        navigate,
        startViewModel::getCurrentMaxLevel,
        width,
        fieldSize,
        viewState.gameField
    )
}

@Composable
fun StartScreen(
    navigate: (String) -> Unit,
    getCurrentLevel: () -> Int,
    width: Dp,
    fieldSize: Dp,
    backGround: List<List<ColorField>>,
) {
    val activity = (LocalContext.current as? Activity)
    var tutorial by remember { mutableIntStateOf(0) }
    val density = LocalDensity.current
    val header =  (width / 6)
    val headerTextSize = with(density) { header.toSp() }
    val menuItemSize = headerTextSize / 1.5f

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Background(fieldSize, backGround)

        when (tutorial) {
            1 -> QuestTutorial((width / 10)) {
                tutorial = 2
            }

            2 -> PowerUpTutorial {
                tutorial = 0
            }

            else -> {}
        }

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .border(
                        width = BorderWidthLarge,
                        color = Color.Black,
                        shape = RoundedCornerShape(Padding.L)
                    ),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)

            ) {

                MyText(
                    stringResource(id = R.string.app_name),
                    fontSize = headerTextSize,
                    style = TextStyle(color = MaterialTheme.colorScheme.primary),
                    modifier = Modifier.padding(Padding.L)
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(Padding.M),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                MenuButton(
                    R.string.play,
                    menuItemSize
                ) { navigate(Screen.Main.name + "/${getCurrentLevel()}") }
                MenuButton(
                    R.string.level_selection,
                    menuItemSize
                ) { navigate(Screen.LEVEL_SELECTION.name) }
                MenuButton(
                    R.string.endless_mode,
                    menuItemSize
                ) { navigate(Screen.Main.name + "/${0}") }
                MenuButton(R.string.tutorial, menuItemSize) { tutorial = 1 }
                MenuButton(R.string.quit, menuItemSize) { activity?.finish() }
            }
        }
    }
}

@Composable
private fun MenuButton(textId: Int, size: TextUnit, onClick: () -> Unit) {
    ElevatedButton(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .border(width = BorderWidthLarge, color = Color.Black, shape = MenuButtonShape),
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colorScheme.secondary,
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        onClick = onClick
    ) {
        MyText(
            text = stringResource(id = textId),
            lineHeight = size,
            fontSize = size,
            textAlign = TextAlign.Center
        )
    }
}


@Preview
@Composable
fun StartPreview() {
    hackClassLoader()
    StartScreen(
        navigate = {},
        getCurrentLevel = { 3 },
        width = 1500.dp,
        fieldSize = 90.dp,
        backGround = listOf(),
    )
}