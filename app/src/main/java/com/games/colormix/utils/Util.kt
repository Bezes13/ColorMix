package com.games.colormix.utils

import android.content.res.Resources
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import java.net.URL
import java.text.NumberFormat
import java.util.Locale
import kotlin.random.Random

fun Float.mapInRange(inMin: Float, inMax: Float, outMin: Float, outMax: Float): Float {
    return outMin + (((this - inMin) / (inMax - inMin)) * (outMax - outMin))
}

fun Dp.toPx() = value.dpToPx()

fun Float.dpToPx() = this * Resources.getSystem().displayMetrics.density

private val random = Random(1232)
fun Float.randomTillZero() = this * random.nextFloat()
fun randomInRange(min: Float, max: Float) = min + (max - min).randomTillZero()
fun randomBoolean(trueProbabilityPercentage: Int) =
    random.nextFloat() < trueProbabilityPercentage / 100f

fun hackClassLoader() {
    val classLoader = ClassLoader.getSystemClassLoader()
    val addURL = classLoader.javaClass.getMethod("addURL", URL::class.java)
    addURL.isAccessible = true
    addURL.invoke(classLoader, URL("file:///path/to/dir/with/resources"))
}

fun getLevelString(level: Int) = "LEVEL$level"

fun Int.withThousandSeparators(): String {
    val formatter = NumberFormat.getInstance(Locale.GERMANY)
    return formatter.format(this)
}

fun manipulateColor(color: Color, factor: Float): Color {
    val r = (color.red * factor)
    val g = (color.green * factor)
    val b = (color.blue * factor)
    return Color(
        r,
        g,
        b,
        color.alpha
    )
}