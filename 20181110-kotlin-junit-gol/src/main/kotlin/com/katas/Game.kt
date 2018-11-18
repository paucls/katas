package com.katas

class Game(var board: Board) {
    fun tick() {
        val nextCells = board.cells.map {
            it.nextGeneration(board.neighboursOf(it))
        }.toSet()

        board = Board(nextCells)
    }
}
