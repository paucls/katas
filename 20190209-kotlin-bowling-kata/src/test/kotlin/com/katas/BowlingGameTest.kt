package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
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
    fun `should have score 1 when knocking down a single pin`() {
        game.roll(1)
        repeat(19) {
            game.roll(0)
        }

        assertThat(game.score()).isEqualTo(1)
    }

    @Test
    fun `should have score 20 after knocking down a single pin per roll`() {
        repeat(20) {
            game.roll(1)
        }

        assertThat(game.score()).isEqualTo(20)
    }

    @Test
    fun `the score for a spare frame is pins in the frame plus pins on next roll`() {
        game.roll(5)
        game.roll(5)
        repeat(18) {
            game.roll(1)
        }

        assertThat(game.score()).isEqualTo(29)
    }

    @Test
    fun `the score for a spare in each frame`() {
        repeat(21) {
            game.roll(5)
        }

        assertThat(game.score()).isEqualTo(150)
    }

    @Ignore
    @Test
    fun `the score for a few strikes followed by no pins`() {
        game.roll(10)
        game.roll(10)
        repeat(18) {
            game.roll(0)
        }

        assertThat(game.score()).isEqualTo(30)
    }
}
