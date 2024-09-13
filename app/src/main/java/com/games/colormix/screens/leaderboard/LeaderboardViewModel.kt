package com.games.colormix.screens.leaderboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.games.colormix.FirebaseRepository
import com.games.colormix.model.BoardScore
import com.games.colormix.model.Score
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.min

@HiltViewModel
class LeaderboardViewModel @Inject constructor(
) : ViewModel() {
    private val _viewState = MutableStateFlow(LeaderBordViewState())
    val viewState = _viewState.asStateFlow()
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firebaseRepository = FirebaseRepository()

    init {
        fetchLeaderboard()
    }
    fun fetchLeaderboard() {
        _viewState.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            val leaderboard = firebaseRepository.getLeaderboard().groupBy { entry -> entry.playerId }
                _viewState.update { state ->
                    state.copy(
                        isLoading = false,
                        leaderboard = leaderboard.map { e -> BoardScore(name = e.value[0].name, points = e.value.sumOf { it.score }) }.sortedByDescending { it.points }.subList(0, min(leaderboard.size, 10)),
                        leaderboardLevelCompleted = leaderboard.map { e -> BoardScore(name = e.value[0].name, points = e.value.size)}.sortedByDescending { it.points }.subList(0,min(leaderboard.size, 10)),
                        player = Score(leaderboard[auth.currentUser?.uid]?.size?:0, leaderboard[auth.currentUser?.uid]?.first()?.name
                            ?:"", auth.currentUser?.uid?:"", leaderboard[auth.currentUser?.uid]?.sumOf { e -> e.score }?: 0 )
                    )
                }


        }
    }
}
