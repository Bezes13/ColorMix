package com.games.colormix.game

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import com.games.colormix.game.VisibilityState.Initial
import com.games.colormix.game.VisibilityState.ToClose
import com.games.colormix.game.VisibilityState.ToPopUp
import kotlinx.coroutines.delay

@Stable
class AwaitedEnterTransition(
    val duration: Int,
    val convert: (Int) -> EnterTransition
) {
    val transition: EnterTransition = convert(duration)
}

operator fun AwaitedEnterTransition.times(value: Int): AwaitedEnterTransition {
    val newDuration = duration * value
    return AwaitedEnterTransition(newDuration, convert)
}

@Stable
class AwaitedExitTransition(
    val duration: Int,
    val convert: (Int) -> ExitTransition
) {
    val transition: ExitTransition = convert(duration)
}

operator fun AwaitedExitTransition.times(value: Int): AwaitedExitTransition {
    val newDuration = duration * value
    return AwaitedExitTransition(newDuration, convert)
}

private const val DEFAULT_DURATION = 300

val defaultExitTransition =
    AwaitedExitTransition(0) {  fadeOut(tween(it)) }

val defaultEnterTransition =
    AwaitedEnterTransition(DEFAULT_DURATION) { slideInVertically(tween(it)) + fadeIn(tween(it)) }



@Stable
private data class WithVisibility<T>(
    val data: T,
    val state: VisibilityState = Initial
)

/**
 * The state of each widget in an [LazyAnimatedColumn].
 * @property Initial the state of all widgets that are passed to the column at the first composition.
 * @property ToPopUp the state that is applied to all widgets that are new compared to the previous version of the list.
 * @property ToClose the state of all widgets that are missing in the new version of the list.
 * When marked with this state, a closing animation will be launched for its widget.
 * After the animation is complete, the item of this widget is deleted.
 */
@Stable
enum class VisibilityState {
    Initial,
    ToPopUp,
    ToClose;

    fun toInitialState(): Boolean = when (this) {
        Initial -> true
        ToClose -> true
        ToPopUp -> false
    }

    fun toTargetState(): Boolean = when (this) {
        Initial -> true
        ToClose -> false
        ToPopUp -> true
    }
}

@Stable
data class ColumnChange<T>(
    val removed: Iterable<IndexedValue<T>>,
    val added: Iterable<IndexedValue<T>>
)

private fun <T> findDifference(
    initial: List<WithVisibility<T>>,
    changed: List<T>,
    keyProvider: (T) -> String,
): ColumnChange<T> {
    val initialTransformed = initial.map { it.data }
    val removedIndices = processChanges(changed, keyProvider, initialTransformed)
    val addedIndices = processChanges(initialTransformed, keyProvider, changed)
    return ColumnChange(removedIndices, addedIndices)
}

private fun <T> processChanges(
    changed: List<T>,
    keyProvider: (T) -> String,
    initialTransformed: List<T>
): MutableList<IndexedValue<T>> {
    val removedIndices = mutableListOf<IndexedValue<T>>()
    val mapChanged = changed.withIndex().associate { keyProvider(it.value) to it.index }
    initialTransformed.forEachIndexed { index, value ->
        if (mapChanged[keyProvider(value)] == null) {
            removedIndices.add(IndexedValue(index, value))
        }
    }
    return removedIndices
}

private fun <T> List<T>.toVisibleItems() = map { WithVisibility(it) }

/**
 *
 *  @param items a list of items of any type ([T]). The items should be wrapped in a [State] to keep them a stable argument.
 *  @param keyProvider a lambda that outputs a key that an item can be uniquely identified with.
 *  @param modifier the [Modifier] to be applied to the column.
 *  @param enterTransition the [EnterTransition] to be applied to each entering widget.
 *  @param exitTransition the [ExitTransition] to be applied to each exiting widget.
 *  @param itemContent an individual widget for an item of type [T]
 */
@Composable
fun <T : Any> LazyAnimatedColumn(
    items: List<T>,
    keyProvider: (T) -> String,
    modifier: Modifier = Modifier,
    lazyModifier: LazyItemScope.() -> Modifier = { Modifier },
    enterTransition: AwaitedEnterTransition = defaultEnterTransition,
    exitTransition: AwaitedExitTransition = defaultExitTransition,
    itemContent: @Composable AnimatedVisibilityScope.(Int, T) -> Unit
) {
    val internalList = remember {
        items.toVisibleItems().toMutableStateList()
    }

    LaunchedEffect(items) {
        val (removedItems, addedItems) = findDifference(internalList, items, keyProvider)
        val total = removedItems + addedItems
        if (total.isNotEmpty()) {
            internalList.run {
                for (removed in removedItems) {
                    this[removed.index] = this[removed.index].copy(state = ToClose)
                }
                for (added in addedItems) {
                    add(added.index, WithVisibility(added.value, ToPopUp))
                }
            }
            delay(maxOf(enterTransition.duration, exitTransition.duration).toLong())
            internalList.clearUpdate(items)
        } else {
            internalList.clearUpdate(items)
        }
    }
    LazyColumn(
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ) {
        items(
            count = internalList.size,
            key = { keyProvider(internalList[it].data) }
        ) { index ->
            val internalLazyModifier = lazyModifier()
            val currentItem = internalList[index]
            AnimatedRemovable(
                key = keyProvider(currentItem.data),
                state = currentItem.state,
                modifier = internalLazyModifier,
                enterTransition = enterTransition.transition,
                exitTransition = exitTransition.transition
            ) {
                itemContent(index, currentItem.data)
            }
        }
    }
}

private fun <T> SnapshotStateList<WithVisibility<T>>.clearUpdate(
    items: List<T>
) {
    clear()
    addAll(items.toVisibleItems())
}


@Composable
internal fun AnimatedRemovable(
    key: String,
    state: VisibilityState,
    modifier: Modifier = Modifier,
    enterTransition: EnterTransition = defaultEnterTransition.transition,
    exitTransition: ExitTransition = defaultExitTransition.transition,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    val internalVisible = remember(key) {
        MutableTransitionState(state.toInitialState())
    }
    LaunchedEffect(state) {
        internalVisible.targetState = state.toTargetState()
    }
    AnimatedVisibility(
        visibleState = internalVisible,
        enter = enterTransition,
        exit = exitTransition,
        modifier = modifier
    ) {
        Column {
            content()
        }
    }
}