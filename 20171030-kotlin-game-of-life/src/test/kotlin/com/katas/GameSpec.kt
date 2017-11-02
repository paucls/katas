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

    }

})