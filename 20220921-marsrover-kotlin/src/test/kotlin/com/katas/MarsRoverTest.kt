package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MarsRoverTest {

    @Test
    fun `should move forward one square`(){
        val rover = MarsRover(Position(0, 0))

        rover.receiveCommand("f")

        assertThat(rover.position).isEqualTo(Position(0 ,1))
    }

    @Test
    fun `should move forward multiple square`(){
        val rover = MarsRover(Position(0, 100))

        rover.receiveCommand("ff")

        assertThat(rover.position).isEqualTo(Position(0 ,102))
    }

    @Test
    fun `should move backward one square`(){
        val rover = MarsRover(Position(0, 0))

        rover.receiveCommand("b")

        assertThat(rover.position).isEqualTo(Position(0 ,-1))
    }
}
