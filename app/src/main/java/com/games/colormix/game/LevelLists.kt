package com.games.colormix.game

import com.games.colormix.data.LevelInfo

object LevelLists {
    val levelList = listOf(LevelInfo(
        quests = listOf(),
        specialBlocks = listOf())
    ).plus(LevelData.LEVEL_GROUP1).plus(LevelData2.LEVEL_GROUP2).plus(LevelData3.Level_GROUP3).plus(listOf(LevelInfo(
        quests = listOf(),
        specialBlocks = listOf())
    ))
}