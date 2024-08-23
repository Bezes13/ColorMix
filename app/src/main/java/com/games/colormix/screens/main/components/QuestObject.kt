package com.games.colormix.screens.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.games.colormix.R
import com.games.colormix.data.LevelQuest
import com.games.colormix.data.SpecialType
import com.games.colormix.data.startColors
import com.games.colormix.utils.manipulateColor

@Composable
fun QuestObject(quest: LevelQuest, size: Dp, modifier: Modifier = Modifier) {
    val brush = Brush.sweepGradient(startColors)
    val mod =
        if (quest.multiBlock != null) modifier.background(brush, CardDefaults.shape) else modifier
    Card(
        elevation = if (quest.multiBlock != null || quest.specialType != SpecialType.None) CardDefaults.cardElevation() else CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(containerColor = quest.color ?: Color.Transparent),
        modifier = mod.size(size),
    )
    {
        if (quest.specialType != SpecialType.None) {
            Image(
                painter = when (quest.specialType) {
                    SpecialType.Rock -> painterResource(id = R.drawable.rock)
                    SpecialType.Box -> painterResource(id = R.drawable.box)
                    SpecialType.OpenBox -> painterResource(id = R.drawable.boxopen)
                    else -> painterResource(id = R.drawable.ic_launcher_foreground)
                },
                alignment = Alignment.Center,
                contentDescription = stringResource(id = R.string.specialtype),
                modifier = Modifier.fillMaxSize()
            )
        }
        val largeRadialGradient = object : ShaderBrush() {
            override fun createShader(size: Size): Shader {
                return RadialGradientShader(
                    colors = listOf(
                        quest.color ?: Color.Transparent,
                        manipulateColor(color = quest.color ?: Color.Transparent, 0.5f)
                    ),
                    center = size.center,
                    radius = size.height,
                    colorStops = listOf(0f, 0.95f)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(largeRadialGradient)
        )
    }
}