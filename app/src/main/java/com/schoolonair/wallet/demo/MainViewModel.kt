package com.schoolonair.wallet.demo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _scoreA = MutableLiveData(0)
    val scoreA: LiveData<Int> get() = _scoreA

    val result = Transformations.map(scoreA) { teamAScore ->
        Log.d("MainViewModel", "result $teamAScore")
        if (teamAScore > 10) "A wins" else ""
    }

    var scoreB : Int = 0

    fun incrementScoreA(scoreToIncrement: Int = 1) {
        _scoreA.value = _scoreA.value?.plus(scoreToIncrement)
    }

    fun incrementScoreB() {
        scoreB++
    }

    override fun onCleared() {
        super.onCleared()

        Log.d("MainViewModel", "onCleared()")
    }
}