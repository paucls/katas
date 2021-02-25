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

    @Test
    fun `a lift should not move when doors are open`() {
        val liftA = Lift(id = "A", floor = 0, doorsOpen = true, requests = listOf(1))
        val liftSystem = LiftSystem(floors = listOf(0, 1), lifts = listOf(liftA), calls = emptyList())

        liftSystem.tick()

        assertThat(liftA.getFloor()).isEqualTo(0)
    }

    @Test
    fun `a lift should close the doors before moving`() {
        val liftA = Lift(id = "A", floor = 0, doorsOpen = true, requests = listOf(1))
        val liftSystem = LiftSystem(floors = listOf(0, 1), lifts = listOf(liftA), calls = emptyList())

        liftSystem.tick()

        assertThat(liftA.areDoorsOpen()).isFalse()
    }

    @Test
    fun `a lift should open doors after arriving to the requested floor`() {
        val liftA = Lift(id = "A", floor = 0, doorsOpen = false, requests = listOf(1))
        val liftSystem = LiftSystem(floors = listOf(0, 1), lifts = listOf(liftA), calls = emptyList())

        liftSystem.tick()
        assertThat(liftA.areDoorsOpen()).isFalse()
        assertThat(liftA.getFloor()).isEqualTo(1)

        liftSystem.tick()
        assertThat(liftA.areDoorsOpen()).isTrue()
    }
}
