package codingdojo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LiftSystemTest {

    @Test
    fun `a lift should move to requested floor`() {
        val liftA = Lift(id = "A", floor = 0, requests = listOf(1))
        val liftSystem = LiftSystem(floors = listOf(0, 1), lifts = listOf(liftA), calls = emptyList())

        liftSystem.tick()

        assertThat(liftA.getFloor()).isEqualTo(1)
    }

    @Test
    fun `a lift should not move when already in requested floor`() {
        val liftA = Lift(id = "A", floor = 0, requests = listOf(0))
        val liftSystem = LiftSystem(floors = listOf(0, 1), lifts = listOf(liftA), calls = emptyList())

        liftSystem.tick()

        assertThat(liftA.getFloor()).isEqualTo(0)
    }
}
