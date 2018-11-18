package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CellShould {

    @Test
    fun `die by underpopulation if has less than 2 live neighbours`() {
        val cell = AliveCell(0, 0)
        val neighbours = setOf(AliveCell(0, 1), DeadCell(1, 0))

        val nextCell = cell.nextGeneration(neighbours)

        assertThat(nextCell is DeadCell).isTrue()
    }

    @Test
    fun `continue living if has 2 live neighbours`() {
        val cell = AliveCell(0, 0)
        val neighbours = setOf(AliveCell(0, 1), AliveCell(1, 0))

        val nextCell = cell.nextGeneration(neighbours)

        assertThat(nextCell is AliveCell).isTrue()
    }

    @Test
    fun `continue living if has 3 live neighbours`() {
        val cell = AliveCell(0, 0)
        val neighbours = setOf(AliveCell(0, 1), AliveCell(1, 0), AliveCell(1, 1))

        val nextCell = cell.nextGeneration(neighbours)

        assertThat(nextCell is AliveCell).isTrue()
    }

    @Test
    fun `die by overpopulation if has more than 3 live neighbours`() {
        val cell = AliveCell(1, 1)
        val neighbours = setOf(AliveCell(0, 0), AliveCell(0, 1), AliveCell(0, 2), AliveCell(1, 0))

        val nextCell = cell.nextGeneration(neighbours)

        assertThat(nextCell is DeadCell).isTrue()
    }

    @Test
    fun `becomes alive if has exactly 3 live neighbours`() {
        val cell = DeadCell(0, 0)
        val neighbours = setOf(AliveCell(0, 1), AliveCell(1, 0), AliveCell(1, 1))

        val nextCell = cell.nextGeneration(neighbours)

        assertThat(nextCell is AliveCell).isTrue()
    }

    @Test
    fun `continues dead if has less than 3 live neighbours`() {
        val cell = DeadCell(0, 0)
        val neighbours = setOf(AliveCell(0, 1), AliveCell(1, 0), DeadCell(1, 1))

        val nextCell = cell.nextGeneration(neighbours)

        assertThat(nextCell is DeadCell).isTrue()
    }

    @Test
    fun `continues dead if has more than 3 live neighbours`() {
        val cell = DeadCell(1, 1)
        val neighbours = setOf(AliveCell(0, 0), AliveCell(0, 1), AliveCell(0, 2), AliveCell(1, 0))

        val nextCell = cell.nextGeneration(neighbours)

        assertThat(nextCell is DeadCell).isTrue()
    }
}