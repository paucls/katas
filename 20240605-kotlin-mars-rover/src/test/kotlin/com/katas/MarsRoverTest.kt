package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MarsRoverTest {

    @Test
    fun `should move forward`() {
        val marsRover = MarsRover(Coordinate(0, 0), "N")

        marsRover.execute("f")

        assertThat(marsRover.position()).isEqualTo(Coordinate(0, 1))
    }

}