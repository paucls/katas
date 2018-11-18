package com.katas

import kotlin.math.abs

class Board(private val cells: Set<Cell>) {

    private val neighborhoodLimit = 1

    fun neighboursOf(cell: Cell): Set<Cell> {
        return cells.filter {
            areNeighbours(it, cell)
        }.toSet()
    }

    private fun areNeighbours(cell1: Cell, cell2: Cell): Boolean {
        return (cell1 != cell2
                && (abs(cell1.y - cell2.y) <= neighborhoodLimit)
                && (abs(cell1.x - cell2.x) <= neighborhoodLimit))
    }
}
