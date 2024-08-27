package com.games.colormix.data

import androidx.compose.ui.unit.dp
import com.games.colormix.utils.mapInRange
import com.games.colormix.utils.randomBoolean
import com.games.colormix.utils.randomInRange
import com.games.colormix.utils.toPx
import kotlin.math.pow

class Particle(
    val maxHorizontalDisplacement: Float,
    val maxVerticalDisplacement: Float,
) {
    private val velocity = 4 * maxVerticalDisplacement
    private val acceleration = -2 * velocity
    var currentXPosition = 0f
    var currentYPosition = 0f

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
            if (explosionProgress > (1 - visibilityThresholdHigh)) {
                alpha = 0f; return
            } else (explosionProgress).mapInRange(0f,1f - visibilityThresholdHigh,0f, 1f)
        alpha = 1f
        currentRadius = startRadius + (endRadius - startRadius) * trajectoryProgress
        val currentTime = trajectoryProgress.mapInRange(0f, 1f, 0f, 1.4f)
        val verticalDisplacement =
            (currentTime * velocity + 0.5 * acceleration * currentTime.toDouble()
                .pow(2.0)).toFloat()
        currentYPosition = initialXDisplacement - verticalDisplacement
        currentXPosition = initialYDisplacement + maxHorizontalDisplacement * trajectoryProgress
    }
}
