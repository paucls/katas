package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object GameSpec : Spek({

    describe("Game") {

        describe("isGameOver()") {

            it("is true when all cells are dead") {
                val game = Game(listOf(Cell(false), Cell(false)))

                assertThat(game.isGameOver()).isTrue()
            }

            it("is false when has alive cells") {
                val game = Game(listOf(Cell(false), Cell(true)))

                assertThat(game.isGameOver()).isFalse()
            }

        }

        describe("next()") {

            it("should call next generation for each cell") {
                val game = Game(listOf(Cell(true), Cell(true), Cell(true)))

                val nextGame = game.next()
                assertThat(nextGame.cells[0].alive).isFalse()
                assertThat(nextGame.cells[1].alive).isTrue()
                assertThat(nextGame.cells[2].alive).isFalse()
            }

        }

        describe("initialization") {

            it("must link each cell with all their left and right neighbours") {
                val cell0 = Cell();
                val cell1 = Cell();
                val cell2 = Cell();
                val game = Game(listOf(cell0, cell1, cell2))

                assertThat(game.cells[0].neighbours).isEqualTo(listOf(cell1))
                assertThat(game.cells[1].neighbours).isEqualTo(listOf(cell0, cell2))
                assertThat(game.cells[2].neighbours).isEqualTo(listOf(cell1))
            }

        }

    }

})