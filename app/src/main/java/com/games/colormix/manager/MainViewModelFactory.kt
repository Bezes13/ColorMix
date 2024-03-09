package com.example.whattowatch.manager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.games.colormix.MainViewModel
import kotlinx.coroutines.CoroutineDispatcher

class MainViewModelFactory(
    private val sharedPreferencesManager: SharedPreferencesManager,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(sharedPreferencesManager, ioDispatcher) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}