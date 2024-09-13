package com.games.colormix.screens.levelselection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.games.colormix.FirebaseRepository
import com.games.colormix.model.Score
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LevelSelectionViewModel @Inject constructor() : ViewModel() {
    private val firebaseRepository = FirebaseRepository()
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private var entries = listOf<Score>()
    init {
        viewModelScope.launch {
            entries = firebaseRepository.getLeaderboard().groupBy { entry -> entry.playerId }[auth.currentUser?.uid]?: listOf()
        }
    }
    fun getCurrentMaxLevel(): Int {
        return entries.size + 1
    }

    fun getCurrentPoints(level: Int): Int {
        return entries.firstOrNull { it.level == level }?.score?: 0
    }
}