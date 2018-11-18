package com.katas

sealed class Cell(val x: Int, val y: Int) {
    fun nextGeneration(neighbours: Set<Cell>): Cell {
        val aliveNeighbours = neighbours.count { it is AliveCell }

        if ((this is AliveCell && aliveNeighbours in 2..3)
                || aliveNeighbours == 3) return AliveCell(x, y)

        return DeadCell(x, y)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cell

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

}

class AliveCell(x: Int, y: Int) : Cell(x, y) {
    override fun toString(): String {
        return "[O]"
    }
}

class DeadCell(x: Int, y: Int) : Cell(x, y) {
    override fun toString(): String {
        return "[X]"
    }
}
