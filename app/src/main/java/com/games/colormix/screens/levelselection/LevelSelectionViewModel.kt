package com.games.colormix.screens.levelselection

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.games.colormix.constants.CurrentLevelString
import com.games.colormix.utils.getLevelString
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class LevelSelectionViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)

    fun getCurrentMaxLevel(): Int {
        return sharedPreferences.getInt(CurrentLevelString, 0)
    }

    fun getCurrentPoints(level: Int): Int {
        return sharedPreferences.getInt(getLevelString(level), 0)
    }
}