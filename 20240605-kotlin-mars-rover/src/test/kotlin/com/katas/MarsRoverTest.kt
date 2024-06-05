package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MarsRoverTest {

    @Test
    fun `should move forward one square`() {
        val marsRover = MarsRover(Coordinate(0, 0), "N")

        marsRover.execute("f")

        assertThat(marsRover.position()).isEqualTo(Coordinate(0, 1))
    }

    @Test
    fun `should move forward two squares`() {
        val marsRover = MarsRover(Coordinate(0, 10), "N")

        marsRover.execute("ff")

        assertThat(marsRover.position()).isEqualTo(Coordinate(0, 12))
    }

    @Test
    fun `should move backward one square`() {
        val marsRover = MarsRover(Coordinate(0, 0), "N")

        marsRover.execute("b")

        assertThat(marsRover.position()).isEqualTo(Coordinate(0, -1))
    }

    @Test
    fun `should move considering what direction is facing`() {
        val marsRover = MarsRover(Coordinate(0, 0), "S")

        marsRover.execute("f")

        assertThat(marsRover.position()).isEqualTo(Coordinate(0, -1))
    }
}