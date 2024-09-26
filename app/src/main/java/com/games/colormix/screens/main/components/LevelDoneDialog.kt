package com.games.colormix.screens.main.components

import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.games.colormix.R
import com.games.colormix.constants.BorderWidth
import com.games.colormix.constants.ExtraBombPoints
import com.games.colormix.constants.ExtraLaserPoints
import com.games.colormix.constants.ExtraMovePoints
import com.games.colormix.constants.Padding
import com.games.colormix.screens.main.MainViewDialog
import com.games.colormix.utils.MyText

@Composable
fun LevelDoneDialog(
    buttonTextId: Int,
    headerTextId: Int,
    bodyText: String,
    event: MainViewDialog.LevelComplete? = null,
    onConfirm: () -> Unit,
) {
    val iconSize = with(LocalDensity.current) { (24.sp).toDp() }

    Dialog(onDismissRequest = onConfirm) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary
            ),
            border = BorderStroke(5.dp, MaterialTheme.colorScheme.secondary)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(Padding.L),
                modifier = Modifier.padding(Padding.L),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MyText(
                    text = stringResource(id = headerTextId),
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Divider(color = MaterialTheme.colorScheme.secondary)
                MyText(text = bodyText)
                if (event != null) {
                    var animatePoints by remember {
                        mutableStateOf(false)
                    }
                    var animateMovePoints by remember {
                        mutableStateOf(false)
                    }
                    var animateBombPoints by remember {
                        mutableStateOf(false)
                    }
                    var animateLaserPoints by remember {
                        mutableStateOf(false)
                    }
                    var animateResultPoints by remember {
                        mutableStateOf(false)
                    }
                    LaunchedEffect(Unit) {
                        animatePoints = true
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        AnimatePoints(
                            {},
                            -1,
                            event.points - event.moves * ExtraMovePoints - event.bombCount * ExtraBombPoints - event.rubikCount * ExtraLaserPoints,
                            animatePoints
                        ) { animateMovePoints = true }
                        AnimatePoints(
                            { MyText(text = "Moves") },
                            event.moves,
                            event.moves * ExtraMovePoints,
                            animatePoints,
                            true
                        ) { animateBombPoints = true }
                        AnimatePoints(
                            {
                                Icon(
                                    modifier = Modifier.size(iconSize),
                                    painter = painterResource(id = R.drawable.meteor),
                                    contentDescription = ""
                                )
                            },
                            event.bombCount,
                            event.bombCount * ExtraBombPoints,
                            animateBombPoints,
                            true
                        ) { animateLaserPoints = true }
                        AnimatePoints(
                            {
                                Icon(
                                    modifier = Modifier.size(iconSize),
                                    painter = painterResource(id = R.drawable.gun),
                                    contentDescription = ""
                                )
                            },
                            event.rubikCount,
                            event.rubikCount * ExtraLaserPoints,
                            animateLaserPoints,
                            true
                        ) { animateResultPoints = true }
                        Divider()
                        AnimatePoints(
                            { MyText(text = "Total") },
                            -1,
                            event.points,
                            animateResultPoints
                        ) {}
                    }


                }
                Image(painterResource(id = R.drawable.goal), contentDescription = "")
                Button(
                    onClick = onConfirm,
                    colors = ButtonDefaults.buttonColors(
                        contentColor = MaterialTheme.colorScheme.tertiary,
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer
                    ),
                    border = BorderStroke(BorderWidth, MaterialTheme.colorScheme.tertiary)
                ) {
                    MyText(text = stringResource(id = buttonTextId))
                }
            }
        }
    }
}

@Composable
private fun AnimatePoints(
    info: @Composable () -> Unit,
    count:Int,
    points: Int,
    run: Boolean,
    plus: Boolean = false,
    onFinish: () -> Unit
) {
    val animatedPoints by animateIntAsState(
        animationSpec = TweenSpec(500),
        targetValue = if (run) points else 0,
        label = "points",
        finishedListener = { onFinish() }
    )
    if (run && points == 0) {
        onFinish()
    }
    Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Row(modifier = Modifier.weight(0.6f),verticalAlignment = Alignment.CenterVertically) {
            info()
            MyText(text = if (count == -1) "" else "($count)")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .weight(1f), horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            MyText(text = if (plus) "+" else "")
            MyText(
                text = animatedPoints.toString().padStart(10, ' '),
            )

        }
    }


}

@Preview
@Composable
fun PreviewLevelDone() {
    LevelDoneDialog(
        buttonTextId = R.string.next_level,
        headerTextId = R.string.completed,
        bodyText = stringResource(
            id = R.string.level_complete_body, 5
        ),
        event = MainViewDialog.LevelComplete("15", 50000, 3, 1, 1)
    ) {

    }
}