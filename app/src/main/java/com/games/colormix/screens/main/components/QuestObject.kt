package com.games.colormix.screens.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.games.colormix.R
import com.games.colormix.data.LevelQuest


@Composable
fun QuestObject(quest: LevelQuest, size: Dp, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(size),
    )
    {
        Image(
            painter = painterResource(id = quest.block.drawId),
            contentDescription = stringResource(R.string.specialtype),
            alignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        )
    }
}