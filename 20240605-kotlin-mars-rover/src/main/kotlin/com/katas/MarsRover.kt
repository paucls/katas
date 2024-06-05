package com.katas

private const val MOVE_FORWARD = 'f'

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
            if (it == MOVE_FORWARD) {
                if (direction == "N")
                    newY += 1
                else if (direction == "S")
                    newY -= 1
            } else {
                newY -= 1
            }
        }
        position = Coordinate(0, newY)
    }

}
