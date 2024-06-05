package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

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

    @ParameterizedTest
    @CsvSource("N,0,1", "S,0,-1", "E,1,0", "W,-1,0")
    fun `should move forward considering what direction is facing`(direction: String, expectedX: Int, expectedY: Int) {
        val marsRover = MarsRover(Coordinate(0, 0), direction)

        marsRover.execute("f")

        assertThat(marsRover.position()).isEqualTo(Coordinate(expectedX, expectedY))
    }
}