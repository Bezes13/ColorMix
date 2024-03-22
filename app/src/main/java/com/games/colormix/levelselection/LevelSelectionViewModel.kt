package com.games.colormix.levelselection

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.games.colormix.MainViewEvent
import com.games.colormix.MainViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LevelSelectionViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {
    private val _event = MutableSharedFlow<MainViewEvent>()
    private val _viewState = MutableStateFlow(MainViewState())
    val viewState = _viewState.asStateFlow()
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
    init {

    }
    fun getCurrentMaxLevel():Int{
        return sharedPreferences.getInt("currentLevel", 0)
    }

    fun getCurrentPoints(level: Int):Int{
        return sharedPreferences.getInt("LEVEL$level", 0)
    }
}