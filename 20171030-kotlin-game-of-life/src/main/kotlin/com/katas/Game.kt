package com.katas

class Game(val cells: List<Cell>) {
    init {
        cells.forEachIndexed { index, cell ->
            if (index - 1 >= 0)
                cell.neighbours += cells[index - 1]

            if (index + 1 < cells.size)
                cell.neighbours += cells[index + 1]
        }
    }

    fun isGameOver(): Boolean = cells.all { !it.alive }

    fun next(): Game {
        return Game(cells.map { it.nextGeneration() })
    }
}