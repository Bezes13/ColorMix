package com.games.colormix.manager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.whattowatch.manager.SharedPreferencesManager
import com.games.colormix.MainViewModel
import kotlinx.coroutines.CoroutineDispatcher

class MainViewModelFactory(
    private val sharedPreferencesManager: SharedPreferencesManager,
    private val ioDispatcher: CoroutineDispatcher,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(sharedPreferencesManager, ioDispatcher, extras.createSavedStateHandle()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}