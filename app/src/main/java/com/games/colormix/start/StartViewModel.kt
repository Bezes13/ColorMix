package com.games.colormix.start

import androidx.lifecycle.ViewModel
import com.example.whattowatch.manager.SharedPreferencesManager
import com.games.colormix.MainViewEvent
import com.games.colormix.MainViewState
import com.games.colormix.R
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class StartViewModel(
    private var sharedPreferencesManager: SharedPreferencesManager,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _event = MutableSharedFlow<MainViewEvent>()
    private val _viewState = MutableStateFlow(MainViewState())
    val viewState = _viewState.asStateFlow()

    init {

    }
    fun getNextLevel():Int{
        return sharedPreferencesManager.getValue(R.string.next_level)
    }
}