package com.games.colormix.screens.main.components.Animation

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun GainPowerUp(powerUpCount: Int, @DrawableRes res: Int) {
    var powerUp by remember { mutableStateOf(false) }
    var previousPowerUpCount by remember { mutableStateOf(0) }
    val offset by animateIntOffsetAsState(
        targetValue = if (powerUp) IntOffset(0, -200) else IntOffset(0, 0),
        animationSpec = TweenSpec(2000),
        label = "offset",
        finishedListener = { powerUp = false }
    )
    LaunchedEffect(key1 = powerUpCount) {
        if (powerUpCount > previousPowerUpCount) {
            powerUp = true
        }
        previousPowerUpCount = powerUpCount
    }
    if (powerUp) {
        Box(contentAlignment = Alignment.Center) {
            Box(modifier = Modifier
                .size(100.dp)
                .offset { offset }
                .alpha(1 - offset.y / -200f), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = res),
                    contentDescription = "powerUp",
                    Modifier.fillMaxSize()
                )
            }
        }
    }
}