package codingdojo

class LiftSystem(
        val floors: List<Int>,
        val lifts: List<Lift> = emptyList(),
        private val calls: List<Call>) {

    fun getCallsForFloor(floor: Int): List<Call> {
        return calls.filter { c -> c.floor == floor }
    }

    fun tick() {
        lifts.forEach { it.tick() }
    }
}
