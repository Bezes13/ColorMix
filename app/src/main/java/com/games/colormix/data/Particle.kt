package com.games.colormix.data


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.games.colormix.mapInRange
import com.games.colormix.randomBoolean
import com.games.colormix.randomInRange
import com.games.colormix.toPx
import kotlin.math.pow

class Particle(
    val color: Color,
    val maxHorizontalDisplacement: Float,
    val maxVerticalDisplacement: Float,
) {
    private val velocity = 4 * maxVerticalDisplacement
    private val acceleration = -2 * velocity
    var currentXPosition = 0f
    var currentYPosition = 0f

    private var visibilityThresholdLow = randomInRange(0f, 0.14f)
    private var visibilityThresholdHigh = randomInRange(0f, 0.4f)

    private val initialXDisplacement = 10.dp.toPx() * randomInRange(-1f, 1f)
    private val initialYDisplacement = 10.dp.toPx() * randomInRange(-1f, 1f)

    var alpha = 0f
    private var currentRadius = 0f
    private val startRadius = 2.dp.toPx()
    private val endRadius = if (randomBoolean(trueProbabilityPercentage = 20)) {
        randomInRange(startRadius, 7.dp.toPx())
    } else {
        randomInRange(1.5.dp.toPx(), startRadius)
    }

    fun updateProgress(explosionProgress: Float) {
        val trajectoryProgress =
            if (explosionProgress < visibilityThresholdLow || (explosionProgress > (1 - visibilityThresholdHigh))) {
                alpha = 0f; return
            } else (explosionProgress - visibilityThresholdLow).mapInRange(0f,1f - visibilityThresholdHigh - visibilityThresholdLow,0f, 1f)
        alpha = explosionProgress
        currentRadius = startRadius + (endRadius - startRadius) * trajectoryProgress
        val currentTime = trajectoryProgress.mapInRange(0f, 1f, 0f, 1.4f)
        val verticalDisplacement =
            (currentTime * velocity + 0.5 * acceleration * currentTime.toDouble()
                .pow(2.0)).toFloat()
        currentYPosition = initialXDisplacement - verticalDisplacement
        currentXPosition = initialYDisplacement + maxHorizontalDisplacement * trajectoryProgress
    }
}
