package com.kata.tictactoeapp.view

import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kata.tictactoeapp.R

import com.kata.tictactoeapp.databinding.MainBinder
import com.kata.tictactoeapp.viewmodel.GameViewModel

class GameActivity : AppCompatActivity() {

    private lateinit var binding : MainBinder
    private lateinit var viewModel : GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        binding.gameViewModel = viewModel
        viewModel.init()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.winner.observe(this, Observer { winner ->
            if (winner == "X") {
                showToast("Player 1 win the game")
                restartGame()

            } else if (winner == "O") {
                showToast("Player 2 win the game")
                restartGame()
            }
        })

        viewModel.areAllCellsFilled.observe(this, Observer { areAllCellsFilled ->
            if (areAllCellsFilled) restartGame()
        })
    }

    private fun showToast(value: String) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show()
    }

    private fun restartGame() {
        viewModel.init()
    }
}