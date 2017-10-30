package com.katas

class Game(val cells: List<Cell>) {
    fun isGameOver(): Boolean = cells.all { !it.alive }

    fun next(): Game {
        return Game(listOf(Cell(false)))
    }
}