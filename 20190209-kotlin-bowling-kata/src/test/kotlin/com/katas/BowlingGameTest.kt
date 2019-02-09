package com.katas

import org.assertj.core.api.Assertions.assertThat
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
}
