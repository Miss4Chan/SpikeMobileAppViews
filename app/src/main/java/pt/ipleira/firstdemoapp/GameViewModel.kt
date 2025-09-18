package pt.ipleira.firstdemoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private var _playedGames = MutableLiveData(0)
    val playedGames: LiveData<Int> = _playedGames

    private var _wonGames = MutableLiveData(0)
    val wonGames: LiveData<Int> = _wonGames

    fun incrementPlayedGames() {
        _playedGames.value = (_playedGames.value ?: 0) + 1
    }

    fun incrementWonGames() {
        _wonGames.value = (_wonGames.value ?: 0) + 1
    }
}