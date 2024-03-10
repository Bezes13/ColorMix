package com.games.colormix

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import kotlin.math.abs

fun Modifier.swipeObserver(move: (Pair<Int, Int>) -> Unit) : Modifier {
    return pointerInput(Unit) {
        var direction = Pair(0,0)
        detectDragGestures(
            onDrag = { change, dragAmount ->
                change.consume()
                val (x, y) = dragAmount
                if (abs(x) > abs(y)) {
                    when {
                        x > 0 -> {
                            //right
                            direction = Pair(1,0)

                        }

                        x < 0 -> {
                            // left
                            direction = Pair(-1,0)
                        }
                    }
                } else {
                    when {
                        y > 0 -> {
                            // down
                            direction = Pair(0,1)
                        }

                        y < 0 -> {
                            // up
                            direction = Pair(0,-1)
                        }
                    }
                }

            },
            onDragEnd = {
                move(direction)
            }
        )
    }
}