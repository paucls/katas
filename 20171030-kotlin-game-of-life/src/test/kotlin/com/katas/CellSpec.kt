package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object CellSpec : Spek({

    describe("A live Cell") {
        it("dies when has less than two alive neighbours") {
            val cell = Cell(true, listOf(Cell(true)))

            assertThat(cell.nextGeneration().alive).isFalse()
        }

        it("survives when has two alive neighbours") {
            val cell = Cell(true, listOf(Cell(true), Cell(true)))

            assertThat(cell.nextGeneration().alive).isTrue()
        }

        it("survives when has three alive neighbours") {
            val cell = Cell(true, listOf(Cell(true), Cell(true), Cell(true)))

            assertThat(cell.nextGeneration().alive).isTrue()
        }

        it("dies when has more than three alive neighbours") {
            val cell = Cell(true, listOf(Cell(true), Cell(true), Cell(true), Cell(true)))

            assertThat(cell.nextGeneration().alive).isFalse()
        }

    }

    describe("A dead Cell") {

        it("stays dead next generation") {
            val cell = Cell(false, listOf(Cell(true), Cell(true)))

            assertThat(cell.nextGeneration().alive).isFalse()
        }

        it("resurrects when has three alive neighbours") {
            val cell = Cell(false, listOf(Cell(true), Cell(true), Cell(true)))

            assertThat(cell.nextGeneration().alive).isTrue()
        }

    }

})