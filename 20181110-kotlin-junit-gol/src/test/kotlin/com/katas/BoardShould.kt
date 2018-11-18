package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class BoardShould {

    @Test
    fun `know that a single cell has no neighbours`() {
        val cell = AliveCell(0, 0)
        val board = Board(setOf(cell))

        val neighbours = board.neighboursOf(cell)

        assertThat(neighbours).isEmpty()
    }

    @Test
    fun `know that two cells next to each other are neighbours`() {
        val cell1 = AliveCell(0, 0)
        val cell2 = AliveCell(0, 1)
        val board = Board(setOf(cell1, cell2))

        val neighboursCell1 = board.neighboursOf(cell1)
        val neighboursCell2 = board.neighboursOf(cell2)

        assertThat(neighboursCell1).containsExactly(cell2)
        assertThat(neighboursCell2).containsExactly(cell1)
    }

    @Test
    fun `know that two remote cells are not neighbours`() {
        val cell1 = AliveCell(0, 0)
        val cell2 = AliveCell(0, 2)
        val cell3 = AliveCell(2, 0)
        val board = Board(setOf(cell1, cell2, cell3))

        val neighboursCell1 = board.neighboursOf(cell1)
        val neighboursCell2 = board.neighboursOf(cell2)
        val neighboursCell3 = board.neighboursOf(cell3)

        assertThat(neighboursCell1).isEmpty()
        assertThat(neighboursCell2).isEmpty()
        assertThat(neighboursCell3).isEmpty()
    }

    @Test
    fun `should know the 8 neighbours surrounding a cell`() {
        val cell = AliveCell(1, 1)
        val board = Board(setOf(
                AliveCell(0, 0), AliveCell(1, 0), AliveCell(2, 0),
                AliveCell(0, 1), cell, AliveCell(2, 1),
                AliveCell(0, 2), AliveCell(1, 2), AliveCell(2, 2)
        ))

        val neighbours = board.neighboursOf(cell)

        assertThat(neighbours).hasSize(8)
    }
}