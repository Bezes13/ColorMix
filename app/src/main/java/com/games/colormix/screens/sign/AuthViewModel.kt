package com.games.colormix.screens.sign

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.games.colormix.FirebaseRepository
import com.games.colormix.constants.CurrentLevelString
import com.games.colormix.utils.getLevelString
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firebaseRepository = FirebaseRepository()
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)

    fun signInAnonymously(name: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            auth.signInAnonymously().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onResult(true)
                    // Transfer old Points into firebase
                    viewModelScope.launch {
                        task.result.user?.let {
                            firebaseRepository.addOrUpdatePlayer(name, it.uid)
                           for (i in 1.. getCurrentMaxLevel()){
                               firebaseRepository.addOrUpdateScore(
                                   level = i,
                                   score = getCurrentPoints(i),
                                   name = name
                               )
                           }
                        }
                    }
                } else {
                    // Anonymous sign-in failed
                    onResult(false)
                }
            }
        }
    }

    private fun getCurrentMaxLevel(): Int {
        return sharedPreferences.getInt(CurrentLevelString, 0)
    }

    private fun getCurrentPoints(level: Int): Int {
        return sharedPreferences.getInt(getLevelString(level), 0)
    }
}
