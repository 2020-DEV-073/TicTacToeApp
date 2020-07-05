package com.kata.tictactoeapp.model

class Game {

    var cells : Array<Array<String>> = createEmptyCells(3)

    val areAllCellsFilled: Boolean
        get() {
            for (row in cells) for (cell in row) if (cell.isEmpty()) return false
            return true
        }

    private val playerOne = "X"
    private val playerTwo = "O"
    private var player = playerOne

    fun play(x: Int, y: Int) {
        if (cells[x][y] == "") {
            cells[x][y] = player
            player = if (player == playerOne) playerTwo else playerOne
        }
    }

    fun winner(): String {
        if (hasWonPlayer(playerOne)) {
            return playerOne
        }
        if (hasWonPlayer(playerTwo)) {
            return playerTwo
        }
        return ""
    }

    private fun hasWonPlayer(player: String): Boolean {
        return hasOneCompleteRow(player)
                || hasOneCompleteColumn(player)
                || hasOneCompleteDiagonal(player)
    }

    private fun hasOneCompleteRow(player: String): Boolean {
        for (i in 0..2) {
            if (player == cells[i][0] && player == cells[i][1] && player == cells[i][2]) {
                return true
            }
        }
        return false
    }

    private fun hasOneCompleteColumn(player: String): Boolean {
        for (i in 0..2) {
            if (player == cells[0][i] && player == cells[1][i] && player == cells[2][i]) {
                return true
            }
        }
        return false
    }

    private fun hasOneCompleteDiagonal(player: String): Boolean {
        return ((player == cells[0][0] && player == cells[1][1] && player == cells[2][2])
                || (player == cells[0][2] && player == cells[1][1] && player == cells[2][0]))
    }

    private fun createEmptyCells(width: Int): Array<Array<String>> {
        var cells = arrayOf<Array<String>>()

        for (i in 1..width) {
            var array = arrayOf<String>()
            for (j in 1..width) array += ""
            cells += array
        }
        return cells
    }
}