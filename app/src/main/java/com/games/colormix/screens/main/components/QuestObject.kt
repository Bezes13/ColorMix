package com.games.colormix.screens.main.components

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import com.games.colormix.data.LevelQuest
import com.games.colormix.utils.FieldDesign


@Composable
fun QuestObject(quest: LevelQuest, size: Dp, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(size),
    )
    {
        val simpleDesign = LocalContext.current.getSharedPreferences("app_preferences", Context.MODE_PRIVATE).getBoolean("Design", false)
        FieldDesign(simpleDesign, size, quest.block)
    }
}