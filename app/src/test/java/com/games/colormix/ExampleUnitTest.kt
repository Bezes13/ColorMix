package com.games.colormix

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val gameField = DummyDaten.GameBoard
    var colorFieldNextId = 100
    @Test
    fun addition_isCorrect() {
        gameField.map { colorFields ->
            var fromTop = true
            colorFields.putOnRightPositionAfterAnimation().mapIndexed { idx, item ->
                if (item == null && fromTop) {
                    ColorField(colorFieldNextId++, animateTo = idx)
                } else {
                    fromTop = false
                    item
                }
            }
        }
    }
}