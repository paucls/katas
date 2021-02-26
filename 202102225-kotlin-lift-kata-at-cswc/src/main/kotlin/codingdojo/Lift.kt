package codingdojo

class Lift(
        val id: String,
        private var floor: Int,
        private val requests: MutableList<Int> = mutableListOf<Int>(),
        private var doorsOpen: Boolean = false) {

    fun getFloor() = floor

    fun hasRequestForFloor(floor: Int): Boolean {
        return requests.contains(floor)
    }

    fun areDoorsOpen(): Boolean {
        return doorsOpen
    }

    fun requestFloor(requestedFloor: Int) {
        requests.add(requestedFloor)
    }

    fun tick() {
        if (requests.isNotEmpty()) {
            doorsOpen = false
            floor = requests.removeAt(0)
        }
        else doorsOpen = true
    }
}
