package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class BowlingGameTest {
    private val game = Game()

    @Test
    fun `should have score 0 if no pin knocked down`() {
        repeat(20) {
            game.roll(0)
        }

        assertThat(game.score()).isEqualTo(0)
    }

    @Test
    fun `should calculate the score of a game with a single pin knocked down`() {
        game.roll(1)
        repeat(19) {
            game.roll(0)
        }

        assertThat(game.score()).isEqualTo(1)
    }

    @Test
    fun `should calculate the score of a game with a single pin knocked down per roll`() {
        repeat(20) {
            game.roll(1)
        }

        assertThat(game.score()).isEqualTo(20)
    }

    @Test
    fun `should calculate the score of a game with a spare in each frame`() {
        repeat(21) {
            game.roll(5)
        }

        assertThat(game.score()).isEqualTo(150)
    }

    @Test
    fun `should calculate the score of a game with a few strikes followed by no pins`() {
        game.roll(10)
        game.roll(10)
        repeat(18) {
            game.roll(0)
        }

        assertThat(game.score()).isEqualTo(30)
    }

    @Test
    fun `should calculate the score of a perfect game`() {
        repeat(12) {
            game.roll(10)
        }

        assertThat(game.score()).isEqualTo(300)
    }
}
