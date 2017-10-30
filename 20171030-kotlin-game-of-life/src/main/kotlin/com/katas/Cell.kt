package com.katas

class Cell(
        val alive: Boolean = false,
        var neighbours: List<Cell> = mutableListOf<Cell>()
) {
    fun nextGeneration(): Cell {
        if (!alive && aliveNeighboursCount() != 3) return this
        return Cell(aliveNeighboursCount() in 2..3)
    }

    private fun aliveNeighboursCount() = neighbours.fold(0) { acc, cell -> if (cell.alive) acc + 1 else acc }
}
