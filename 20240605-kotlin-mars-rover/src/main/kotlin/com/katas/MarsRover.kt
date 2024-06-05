package com.katas

class MarsRover(
    initialPosition: Coordinate,
    initialDirection: String
) {
    private var position = initialPosition
    private var direction = initialDirection

    fun position(): Coordinate {
        return position
    }

    fun execute(commands: String) {
        var newY = position.y
        commands.forEach {
            newY += 1
        }
        position = Coordinate(0, newY)
    }

}
