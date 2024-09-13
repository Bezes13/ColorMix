package com.games.colormix.screens.leaderboard

import com.games.colormix.model.BoardScore
import com.games.colormix.model.Score

data class LeaderBordViewState (
    val isLoading: Boolean = true,
    val leaderboard: List<BoardScore> = listOf(),
    val leaderboardLevelCompleted: List<BoardScore> = listOf(),
    val player: Score = Score(0,"", "",0)
)