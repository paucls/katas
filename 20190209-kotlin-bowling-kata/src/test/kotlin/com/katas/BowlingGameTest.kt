package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test

class BowlingGameTest {
    private val game = Game()

    @Test
    fun `should start with score 0`() {
        assertThat(game.score()).isEqualTo(0)
    }

    @Test
    fun `should have score 1 when knocking down a single pin`() {
        game.roll(1)

        assertThat(game.score()).isEqualTo(1)
    }

    @Test
    fun `should have score 20 after knocking down a single pin per roll`() {
        repeat(20) {
            game.roll(1)
        }

        assertThat(game.score()).isEqualTo(20)
    }

    @Ignore
    @Test
    fun `the score for a spare frame is pins in the frame plus pins on next roll`() {
        game.roll(5)
        game.roll(5)
        game.roll(1)

        assertThat(game.score()).isEqualTo(12)
    }
}
