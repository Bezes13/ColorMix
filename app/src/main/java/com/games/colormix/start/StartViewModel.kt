package com.games.colormix.start

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.games.colormix.data.LevelInfo
import com.games.colormix.data.LevelQuest
import com.games.colormix.data.SpecialBlockPlacement
import com.games.colormix.data.SpecialType
import com.games.colormix.data.estimateMoves
import com.games.colormix.data.generateObjectDefinition
import com.games.colormix.data.startColor
import com.games.colormix.game.LevelLists
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class StartViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val ioDispatcher: CoroutineDispatcher,
    ) : ViewModel() {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
    private val _event = MutableSharedFlow<StartViewEvent>()
    private val _viewState = MutableStateFlow(StartViewState())
    val viewState = _viewState.asStateFlow()
    var backgroundSize = Pair(0,0)
    init {
        listenToEvent()

        viewModelScope.launch(ioDispatcher) {
            delay(400)
            _viewState.update {
                 it.copy(animateAt = it.animateAt.plus(Pair(2,5)))
            }
        }
    }

    fun sendEvent(event: StartViewEvent) {
        viewModelScope.launch(ioDispatcher) {
            _event.emit(event)
        }
    }

    private fun listenToEvent() = viewModelScope.launch(ioDispatcher) {
        _event.collect { event ->
            when (event) {
                is StartViewEvent.RemoveAnimationAt -> {
                    viewModelScope.launch(ioDispatcher) {
                        delay(400)
                        _viewState.update { it.copy(animateAt = listOf(
                            randomPair(),
                            randomPair(),
                            randomPair()
                        )) }
                    }
                }
            }
        }
    }

    private fun randomPair() =
        Pair(Random.nextInt(0, backgroundSize.first), Random.nextInt(0, backgroundSize.second))

    private fun generateNewLevel(): LevelInfo {
        val questCount = if (Math.random() > 0.5) 1 else 2
        var quests = mutableListOf<LevelQuest>()
        val specials = mutableListOf<SpecialBlockPlacement>()
        for (i in 1..questCount) {
            var typeRandom = Math.random()
            var quest =
                if (typeRandom < 0.33) createColorQuest() else if (typeRandom < 0.66) createMultiQuest() else createBoxQuest()
            while (quests.any { it.specialType == quest.specialType && it.color == quest.color }) {

                typeRandom = Math.random()
                quest =
                    if (typeRandom < 0.33) createColorQuest() else if (typeRandom < 0.66) createMultiQuest() else createBoxQuest()
            }
            quests.add(quest)
        }
        quests.forEach {
            if (it.specialType == SpecialType.Box || it.specialType == SpecialType.OpenBox) {
                for (i in 1..it.amount) {
                    var pos = Pair(Random.nextInt(0, 6), Random.nextInt(0, 7))
                    while (specials.any { it.pos == pos }) {

                        pos = Pair(Random.nextInt(0, 6), Random.nextInt(0, 7))
                    }
                    specials.add(SpecialBlockPlacement(it.specialType, pos))
                }
            }
        }
        for (i in 0..Random.nextInt(0, 5)) {
            var pos = Pair(Random.nextInt(0, 6), Random.nextInt(0, 7))
            while (specials.any { it.pos == pos }) {

                pos = Pair(Random.nextInt(0, 6), Random.nextInt(0, 7))
            }
            specials.add(SpecialBlockPlacement(SpecialType.Rock, pos))
        }
        quests =
            quests.map { if (it.specialType == SpecialType.Box) it.copy(specialType = SpecialType.OpenBox) else it }
                .toMutableList()
        if (quests.size == 2 && quests[0].specialType == SpecialType.OpenBox && quests[1].specialType == SpecialType.OpenBox) {
            quests = listOf(
                LevelQuest(
                    SpecialType.OpenBox,
                    Color.Transparent,
                    quests[0].amount + quests[1].amount,
                    null
                )
            ).toMutableList()
        }
        val level = LevelInfo(quests, specials)
        if (level.estimateMoves() > 20 && !LevelLists.levelList.contains(level))
            println(level.generateObjectDefinition())
        return level
    }

    private fun createBoxQuest(): LevelQuest {
        return LevelQuest(
            if (Math.random() > 0.5) SpecialType.OpenBox else SpecialType.Box,
            null,
            Random.nextInt(1, 10)
        )
    }

    private fun createMultiQuest(): LevelQuest {
        return LevelQuest(SpecialType.None, null, Random.nextInt(1, 10), Random.nextInt(5, 10))
    }

    private fun createColorQuest(): LevelQuest {
        return LevelQuest(SpecialType.None, startColor(), Random.nextInt(4, 20), null)
    }


    fun getCurrentMaxLevel(): Int {
        return sharedPreferences.getInt("currentLevel", 1)
    }
}

sealed class StartViewEvent {
    data object RemoveAnimationAt : StartViewEvent()

}