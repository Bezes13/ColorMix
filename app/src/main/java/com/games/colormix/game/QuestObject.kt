package com.games.colormix.game

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.games.colormix.R
import com.games.colormix.data.LevelQuest
import com.games.colormix.data.SpecialType
import com.games.colormix.data.startColors
import com.games.colormix.main.FieldSize

@Composable
fun QuestObject(quest: LevelQuest) {
    val brush = Brush.sweepGradient(startColors)
    val modifier = if (quest.multiBlock != null) Modifier.background(brush) else Modifier
    Card(
        colors = CardDefaults.cardColors(
            containerColor = quest.color ?: Color.Transparent
        ),
        modifier = modifier.size(FieldSize / 2),
        shape = RoundedCornerShape(2.dp),
        border = if (quest.specialType == SpecialType.None) BorderStroke(
            1.dp,
            Color.Black
        ) else BorderStroke(0.dp, Color.Black)
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
                contentDescription = "SpecialType",
                alignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}