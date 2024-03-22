package com.games.colormix.start

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {
    private val _viewState = MutableStateFlow(StartViewState())
    val viewState = _viewState.asStateFlow()
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
    init {

    }
    fun getCurrentMaxLevel():Int{
        return sharedPreferences.getInt("currentLevel", 0)
    }
}