package com.kata.tictactoeapp

import com.kata.tictactoeapp.model.Game
import org.junit.Test
import org.junit.Assert.*


class GameUnitTest {
    @Test
    fun testInitial() {
        val game = Game()
        val winner = game.winner()
        assertEquals("", winner)
    }

    @Test
    fun testplayer1CompletedRow() {
        val game = Game()
        game.play(0, 0)
        game.play(1, 0)
        game.play(0, 1)
        game.play(1, 1)
        game.play(0, 2)
        val winner = game.winner()
        assertEquals("X", winner)
    }

    @Test
    fun testplayer1CompletedColumn() {
        val game = Game()
        game.play(0, 2)
        game.play(1, 0)
        game.play(1, 2)
        game.play(1, 1)
        game.play(2, 2)
        val winner = game.winner()
        assertEquals("X", winner)
    }

    @Test
    fun testplayer1CompletedDiagonal() {
        val game = Game()
        game.play(0, 0)
        game.play(1, 0)
        game.play(1, 1)
        game.play(2, 1)
        game.play(2, 2)
        val winner = game.winner()
        assertEquals("X", winner)
    }

    @Test
    fun testplayer2CompletedRow() {
        val game = Game()
        game.play(1, 0)
        game.play(0, 0)
        game.play(2, 0)
        game.play(0, 1)
        game.play(1, 1)
        game.play(0, 2)
        val winner = game.winner()
        assertEquals("O", winner)
    }

    @Test
    fun testplayer2CompletedColumn() {
        val game = Game()
        game.play(1, 2)
        game.play(0, 1)
        game.play(2, 0)
        game.play(1, 1)
        game.play(1, 0)
        game.play(2, 1)
        val winner = game.winner()
        assertEquals("O", winner)
    }

    @Test
    fun testplayer2CompletedDiagonal() {
        val game = Game()
        game.play(1, 2)
        game.play(0, 0)
        game.play(2, 0)
        game.play(1, 1)
        game.play(1, 0)
        game.play(2, 2)
        val winner = game.winner()
        assertEquals("O", winner)
    }

    @Test
    fun testAllCellsAreFilled() {
        val game = Game()
        game.play(0, 0)
        game.play(0, 2)
        game.play(0, 1)
        game.play(1, 1)
        game.play(1, 2)
        game.play(1, 0)
        game.play(2, 2)
        game.play(2, 1)
        game.play(2, 0)
        val winner = game.winner()
        assertEquals("", winner)
    }

    @Test
    fun testNoChangeIfPlayedOnSamePosition() {
        val game = Game()
        game.play(0, 0)
        game.play(1, 0)
        game.play(0, 1)
        game.play(0, 0)
        game.play(1, 1)
        game.play(0, 2)
        val winner = game.winner()
        assertEquals("X", winner)
    }
}