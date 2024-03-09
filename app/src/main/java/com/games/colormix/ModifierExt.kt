package com.games.colormix

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import kotlin.math.abs

fun Modifier.swipeObserver(move: (Direction) -> Unit) : Modifier {
    return pointerInput(Unit) {
        var direction = Direction.NONE
        detectDragGestures(
            onDrag = { change, dragAmount ->
                change.consume()
                val (x, y) = dragAmount
                if (abs(x) > abs(y)) {
                    when {
                        x > 0 -> {
                            //right
                            direction = Direction.RIGHT
                        }

                        x < 0 -> {
                            // left
                            direction = Direction.LEFT
                        }
                    }
                } else {
                    when {
                        y > 0 -> {
                            // down
                            direction = Direction.DOWN
                        }

                        y < 0 -> {
                            // up
                            direction = Direction.UP
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