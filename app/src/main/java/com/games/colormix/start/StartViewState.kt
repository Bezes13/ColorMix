package com.games.colormix.start

import com.games.colormix.constants.LEVEL_SIZE_X
import com.games.colormix.data.ColorField

data class StartViewState(
    val gameField: List<List<ColorField>> = (0 until LEVEL_SIZE_X).map {
        arrayOf<ColorField>().toList()
    },
)
