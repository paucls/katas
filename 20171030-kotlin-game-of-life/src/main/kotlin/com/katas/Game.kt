package com.katas

class Game(
        val colsCount: Int,
        val rowsCount: Int,
        val cells: List<Cell>
) {
    init {
        cells.forEachIndexed { index, cell ->
            if (index % colsCount > 0)
                cell.neighbours += cells[index - 1]

            if (index % colsCount + 1 < colsCount)
                cell.neighbours += cells[index + 1]

            if (index + colsCount < cells.size)
                cell.neighbours += cells[index + colsCount]
        }
    }

    fun isGameOver(): Boolean = cells.all { !it.alive }

    fun next(): Game {
        return Game(colsCount, rowsCount, cells.map { it.nextGeneration() })
    }
}