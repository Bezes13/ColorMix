package com.games.colormix

import com.games.colormix.model.Player
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class FirebaseRepository {

    private val db: FirebaseFirestore = Firebase.firestore
    private val leaderboardCollection = db.collection("leaderboard")

    // Add or Update a player with points
    suspend fun addOrUpdatePlayer(playerName: String, points: Int) {
        try {
            val playerData = Player(playerName, points)
            leaderboardCollection.document(playerName).set(playerData).await()
        } catch (e: Exception) {
            e.printStackTrace() // Handle error
        }
    }

    // Get the leaderboard list
    suspend fun getLeaderboard(): List<Player> {
        return try {
            val snapshot = leaderboardCollection
                .orderBy("points", com.google.firebase.firestore.Query.Direction.DESCENDING)
                .get()
                .await()

            snapshot.toObjects(Player::class.java)
        } catch (e: Exception) {
            e.printStackTrace() // Handle error
            emptyList()
        }
    }
}