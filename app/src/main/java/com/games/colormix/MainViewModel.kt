package com.games.colormix

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whattowatch.manager.SharedPreferencesManager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private var sharedPreferencesManager: SharedPreferencesManager,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _event = MutableSharedFlow<MainViewEvent>()
    private val _viewState = MutableStateFlow(MainViewState())
    val viewState = _viewState.asStateFlow()

    init {
        _viewState.update { it.copy(isLoading = true) }
        initViewModel()
        listenToEvent()
        _viewState.update { it.copy(isLoading = false) }
    }

    private fun initViewModel() {

    }

    fun sendEvent(event: MainViewEvent) {
        viewModelScope.launch(ioDispatcher) {
            _event.emit(event)
        }
    }

    private fun listenToEvent() = viewModelScope.launch(ioDispatcher) {
        _event.collect { event ->
            when (event) {
                is MainViewEvent.SetDialog -> updateDialog(event.dialog)
            }
        }
    }

    private fun updateDialog(dialog: MainViewDialog) {
        _viewState.update { it.copy( dialog = dialog) }
    }
}

sealed class MainViewEvent {
    data class SetDialog(val dialog: MainViewDialog) : MainViewEvent()
}