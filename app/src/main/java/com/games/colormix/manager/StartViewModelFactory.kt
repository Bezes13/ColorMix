package com.games.colormix.manager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whattowatch.manager.SharedPreferencesManager
import com.games.colormix.start.StartViewModel
import kotlinx.coroutines.CoroutineDispatcher

class StartViewModelFactory (
    private val sharedPreferencesManager: SharedPreferencesManager,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StartViewModel::class.java)) {
            return StartViewModel(sharedPreferencesManager, ioDispatcher) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}