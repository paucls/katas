package com.katas

class Lift(
        private val display: Display,
        var floor: Int
) {
    fun request(floor: Int, direction: Direction) {
        if (this.floor == floor) return

        if (direction == Direction.UP) {
            for (i in (this.floor + 1)..floor) {
                this.floor = i
                displayCurrentFloor()
            }
        } else {
            for (i in (this.floor - 1) downTo floor) {
                this.floor = i
                displayCurrentFloor()
            }
        }
    }

    private fun displayCurrentFloor() {
        display.show("Floor: ${this.floor}")
    }
}

enum class Direction {
    UP,
    DOWN
}