package codingdojo

class Lift(
        val id: String,
        private var floor: Int,
        private val requests: List<Int> = emptyList(),
        private var doorsOpen: Boolean = false) {

    fun getFloor() = floor

    fun hasRequestForFloor(floor: Int): Boolean {
        return requests.contains(floor)
    }

    fun areDoorsOpen(): Boolean {
        return doorsOpen
    }

    fun tick() {
        if (doorsOpen) {
            closeDoors()
            return
        }
        if (floor != requests.first()) {
            floor = requests.first()
        } else {
            doorsOpen = true
        }
    }

    private fun closeDoors() {
        doorsOpen = false
    }
}
