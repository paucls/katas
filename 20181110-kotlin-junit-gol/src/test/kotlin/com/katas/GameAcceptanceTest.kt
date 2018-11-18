package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GameAcceptanceTest {

    @Test
    fun `game has a new generation on each tick`() {
        val board = Board(setOf(
                AliveCell(0, 0), AliveCell(0, 1), AliveCell(0, 2)
        ))
        val game = Game(board)

        game.tick()

        assertThat(game.board).isEqualTo(Board(setOf(
                DeadCell(0, 0), AliveCell(0, 1), DeadCell(0, 2)
        )))
    }
}