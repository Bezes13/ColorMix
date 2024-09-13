package com.games.colormix.screens.main.components.animations

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.games.colormix.data.BlockType
import com.games.colormix.data.Particle
import com.games.colormix.utils.FieldDesign
import com.games.colormix.utils.randomInRange
import com.games.colormix.utils.toPx
import kotlin.math.roundToInt

@Composable
fun BlockExplosion(progress: Float, block: BlockType) {
    val sizeDp = 200.dp
    val sizePx = sizeDp.toPx()
    val simpleDesign = LocalContext.current.getSharedPreferences("app_preferences", Context.MODE_PRIVATE).getBoolean("Design", false)
    val particles = remember {
        List(10) {
            Particle(
                maxHorizontalDisplacement = sizePx * randomInRange(-0.9f, 0.9f),
                maxVerticalDisplacement = sizePx * randomInRange(0.2f, 0.38f),
            )
        }
    }
    particles.forEach { it.updateProgress(progress) }
    particles.forEach { particle ->
        Box(
            modifier = Modifier
                .size(20.dp)
                .offset {
                    IntOffset(
                        (particle.currentXPosition).roundToInt(),
                        particle.currentYPosition.roundToInt()
                    )
                }
                .alpha(particle.alpha),
        ) {
            FieldDesign(simpleDesign, 20.dp, block)
        }
    }
}