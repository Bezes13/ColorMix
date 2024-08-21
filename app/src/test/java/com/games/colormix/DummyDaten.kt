package com.games.colormix

import androidx.compose.ui.graphics.Color
import com.games.colormix.data.ColorField

object DummyDaten {

    val GameBoard: List<List<ColorField?>> =
        (0 until 6).map { listOf(obj1, obj2,obj3, obj4, obj15) }

    val obj1 = ColorField(
        1,
        Color.Red,
    )
    val obj2 = ColorField(
        2,
        Color.Blue,

    )
    val obj3 = ColorField(
        3,
        Color.Green,

    )
    val obj4 = ColorField(
        4,
        Color.Cyan,

    )
    val obj5 = ColorField(
        5,
        Color.Cyan,

    )
    val obj11 = ColorField(
        11,
        Color.Red,

    )
    val obj12 = ColorField(
        12,
        Color.Blue,

    )
    val obj13 = ColorField(
        13,
        Color.Green,

    )
    val obj14 = ColorField(
        14,
        Color.Cyan,

    )
    val obj15 = ColorField(
        15,
        Color.Cyan,

    )
}
