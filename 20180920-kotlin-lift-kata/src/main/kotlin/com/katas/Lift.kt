package com.katas

class Lift(
        private val display: Display,
        var floor: Int
) {
    fun request(floor: Int, direction: Direction) {
        if (this.floor == floor) return

        this.floor = floor

        display.show("Floor: $floor")
    }
}

enum class Direction {
    UP,
    DOWN
}