package com.katas

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GameShould {

    @Test
    fun `tell each cell on the board to calculate next generation`() {
        val cell1: AliveCell = mock()
        val cell2: AliveCell = mock()
        val board = Board(setOf(cell1, cell2))
        val game = Game(board)

        val nextCell1 = AliveCell(0, 0)
        val nextCell2 = AliveCell(0, 1)
        whenever(cell1.nextGeneration(any())).thenReturn(nextCell1)
        whenever(cell2.nextGeneration(any())).thenReturn(nextCell2)

        game.tick()

        assertThat(game.board).isEqualTo(Board(setOf(nextCell1, nextCell2)))
    }
}