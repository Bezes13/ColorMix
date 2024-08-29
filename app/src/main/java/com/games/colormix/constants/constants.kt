package com.games.colormix.constants

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

// Game values
const val BOMB_GAIN_MULTI_BLOCK = 6
const val RUBIK_GAIN_MULTI_BLOCK = 50
const val LEVEL_SIZE_X = 8
const val LEVEL_SIZE_Y = 8
const val BackgroundBlocks = (LEVEL_SIZE_X + 2)

// LevelSelection
const val ItemRowCount = 3

// MainScreen
const val infoCardHeightMultiplier = 8

// Paddings
object Padding {
    val S = 2.dp
    val M = 5.dp
    val L = 10.dp
    val XL = 15.dp
}

// Alpha
const val CardAlpha = 0.6f

val MenuButtonShape = RoundedCornerShape(50.dp)

// Border
val BorderWidth = 3.dp
val BorderWidthLarge = 5.dp

// SavedStrings
const val CurrentLevelString = "currentLevel"
const val TutorialString = "tutorial"

// Animation
const val ExplosionDuration = 200
const val BlockAnimationDuration = 500
const val ParticleCount = 30
