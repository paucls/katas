package codingdojo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LiftSystemTest {

    private val liftA = Lift(id = "A", floor = 0, doorsOpen = false)
    private val liftB = Lift(id = "B", floor = 0, doorsOpen = true)
    private val liftSystem = LiftSystem(floors = listOf(0, 1, 2), lifts = listOf(liftA, liftB), calls = emptyList())

    @Test
    fun `should move to requested floor to fulfill a request`() {
        val requestedFloor = 1

        liftA.requestFloor(requestedFloor)
        assertThat(liftA.getFloor()).isNotEqualTo(requestedFloor)
        liftSystem.tick()

        assertThat(liftA.getFloor()).isEqualTo(requestedFloor)
    }

    @Test
    fun `should move to multiple requested floors to fulfill all requests`() {
        liftA.requestFloor(1)
        liftSystem.tick()
        assertThat(liftA.getFloor()).isEqualTo(1)

        liftA.requestFloor(2)
        liftSystem.tick()
        assertThat(liftA.getFloor()).isEqualTo(2)
    }

    @Test
    fun `should not go anywhere if there are not requests`() {
        liftSystem.tick()

        assertThat(liftA.getFloor()).isEqualTo(0)
    }

    @Test
    internal fun `should open doors after fulfilling a request`() {
        liftA.requestFloor(1)

        liftSystem.tick()
        assertThat(liftA.areDoorsOpen()).isFalse()

        liftSystem.tick()
        assertThat(liftA.areDoorsOpen()).isTrue()
    }

    @Test
    internal fun `should close doors after request for floor`() {
        liftB.requestFloor(1)

        liftSystem.tick()

        assertThat(liftB.areDoorsOpen()).isFalse()
    }
}
