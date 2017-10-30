package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object GameSpec : Spek({

    describe("Game") {

        on("Current Generation") {
            it("is over when all cells are dead") {
                val game = Game(listOf(Cell(false), Cell(false)))

                assertThat(game.isGameOver()).isTrue()
            }

            it("continues when next generation has alive cells") {
                val game = Game(listOf(Cell(false), Cell(true)))

                assertThat(game.isGameOver()).isFalse()
            }
        }

        on("Next Generation") {
            it("1x1 Grid always dies") {
                val game = Game(listOf(Cell(true)))

                assertThat(game.next().isGameOver()).isTrue()
            }

            it("4x1 Grid where one survives") {
                val game = Game(listOf(Cell(false), Cell(true), Cell(true), Cell(true)))

                val nextGame = game.next()
                assertThat(nextGame.isGameOver()).isFalse()
                assertThat(nextGame.cells[0].alive).isFalse()
                assertThat(nextGame.cells[1].alive).isFalse()
                assertThat(nextGame.cells[2].alive).isTrue()
                assertThat(nextGame.cells[3].alive).isFalse()
            }
        }

    }

})