package com.games.colormix

import com.games.colormix.model.Player
import com.games.colormix.model.Score
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class FirebaseRepository {

    private val db: FirebaseFirestore = Firebase.firestore
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val leaderboardCollection = db.collection("leaderboard")
    private val playerCollection = db.collection("player")

    suspend fun addOrUpdatePlayer(playerName: String, uid: String) {
        try {
            val playerData = Player(playerName, uid)
            playerCollection.document(uid).set(playerData).await()
            updatePlayerNameByPlayerId(uid, playerName)
        } catch (e: Exception) {
            e.printStackTrace() // Handle error
        }
    }

    suspend fun addOrUpdateScore(score: Int, level: Int, name: String) {
        try {
            auth.currentUser?.uid?.let {
                val scoreData = Score(level = level, score = score, playerId = it, name = name)
                leaderboardCollection.document("$level _$it").set(scoreData).await()
            }
        } catch (e: Exception) {
            e.printStackTrace() // Handle error
        }
    }

    suspend fun addOrUpdateScore(score: Int, level: Int) {
        try {
            val oldScore = getScore(level)
            if (oldScore == null || oldScore.score < score){
                auth.currentUser?.uid?.let {
                    val scoreData = Score(level = level, score = score, playerId = it, name = getPlayerName()?:"" )
                    leaderboardCollection.document("$level _$it").set(scoreData).await()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace() // Handle error
        }
    }

    suspend fun getPlayerName(): String? {
        return try {
            val documentSnapshot = playerCollection
                .document(auth.currentUser?.uid?:"")
                .get()
                .await()

            documentSnapshot.toObject(Player::class.java)?.name
        } catch (e: Exception) {
            e.printStackTrace() // Handle error
            null
        }
    }

    private suspend fun getScore(level: Int): Score? {
        return try {

            val documentSnapshot = leaderboardCollection
                .document("$level _${auth.currentUser?.uid}")
                .get()
                .await()

            documentSnapshot.toObject(Score::class.java)
        } catch (e: Exception) {
            e.printStackTrace() // Handle error
            null
        }
    }


    suspend fun getLeaderboard(): List<Score> {
        return try {
            val snapshot = leaderboardCollection
                .get()
                .await()

            snapshot.toObjects(Score::class.java)
        } catch (e: Exception) {
            e.printStackTrace() // Handle error
            emptyList()
        }
    }

    private suspend fun updatePlayerNameByPlayerId(playerId: String, newName: String) {
        try {
            // Query the leaderboard collection to find all entries with the specific playerId
            val snapshot = leaderboardCollection
                .whereEqualTo("playerId", playerId)
                .get()
                .await()
            // Loop through all matching documents and update the name field
            for (document in snapshot.documents) {
                leaderboardCollection.document(document.id)
                    .update("name", newName)
                    .await() // Ensure each update is awaited
            }
        } catch (e: Exception) {
            e.printStackTrace() // Handle error
        }
    }
}