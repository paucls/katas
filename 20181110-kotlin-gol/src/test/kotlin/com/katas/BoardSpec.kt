package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object BoardSpec : Spek({

    describe("Board") {

        it("should know that a single cell has zero neighbours") {
            val board = Board(setOf(Cell(0, 0)))

            val neighbours = board.neighboursOf(Cell(0, 0))

            assertThat(neighbours).hasSize(0)
        }

        it("should know that two cells next to each other are neighbours") {
            val board = Board(setOf(Cell(0, 0), Cell(0, 1)))

            assertThat(board.neighboursOf(Cell(0, 0))).containsExactly(Cell(0, 1))
            assertThat(board.neighboursOf(Cell(0, 1))).containsExactly(Cell(0, 0))
        }

        it("should know the 8 neighbours of a cell in the middle") {
            val board = Board(setOf(
                    Cell(0, 0), Cell(1, 0), Cell(2, 0),
                    Cell(0, 1), Cell(1, 1), Cell(2, 1),
                    Cell(0, 2), Cell(1, 2), Cell(2, 2)
            ))

            val neighbours = board.neighboursOf(Cell(1, 1))

            assertThat(neighbours).hasSize(8)
            assertThat(neighbours).contains(
                    Cell(0, 0), Cell(1, 0), Cell(2, 0),
                    Cell(0, 1), Cell(2, 1),
                    Cell(0, 2), Cell(1, 2), Cell(2, 2))
        }

        it("should know that two vertically distant cells are not neighbours") {
            val board = Board(setOf(Cell(0, 0), Cell(0, 2)))

            assertThat(board.neighboursOf(Cell(0, 0))).isEmpty()
            assertThat(board.neighboursOf(Cell(0, 2))).isEmpty()
        }

        it("should know that two horizontally distant cells are not neighbours") {
            val board = Board(setOf(Cell(0, 0), Cell(2, 0)))

            assertThat(board.neighboursOf(Cell(0, 0))).isEmpty()
            assertThat(board.neighboursOf(Cell(2, 0))).isEmpty()
        }

    }

})