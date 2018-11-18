package com.katas

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val board = Board(setOf(
                    AliveCell(0, 0), DeadCell(1, 0), AliveCell(2, 0), AliveCell(3, 0),
                    AliveCell(0, 1), AliveCell(1, 1), AliveCell(2, 1), DeadCell(3, 1),
                    AliveCell(0, 2), AliveCell(1, 2), DeadCell(2, 2), AliveCell(3, 2)
            ))
            val game = Game(board)
            println(game.board)

            do {
                game.tick()
                println(game.board)
            } while (game.board.cells.any { it is AliveCell })
        }
    }
}