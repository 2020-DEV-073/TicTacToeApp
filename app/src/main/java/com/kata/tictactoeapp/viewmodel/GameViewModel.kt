package com.kata.tictactoeapp.viewmodel

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kata.tictactoeapp.model.Game


class GameViewModel : ViewModel() {

    val winner: LiveData<String>
        get() = _winner

    val areAllCellsFilled: LiveData<Boolean>
        get() = _areAllCellsFilled

    var cells: ObservableArrayMap<String, String>? = null

    private val _winner = MutableLiveData<String>()

    private val _areAllCellsFilled = MutableLiveData<Boolean>()

    private lateinit var game: Game

    fun init() {
        cells = ObservableArrayMap()
        game = Game()
    }

    fun getWinner() {
        _winner.value = game.winner()
    }

    fun getAreAllCellsFilled() {
        _areAllCellsFilled.value = game.areAllCellsFilled
    }

    fun onClickedCellAt(row: Int, column: Int) {
        this.game.play(row, column)
        cells!!.put("" + row + column, game.cells[row][column])
        getWinner()
        getAreAllCellsFilled()
    }
}