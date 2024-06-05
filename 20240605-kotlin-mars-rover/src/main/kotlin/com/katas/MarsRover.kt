package com.katas

private const val MOVE_FORWARD = 'f'
private const val N = "N"
private const val S = "S"
private const val E = "E"

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
        var newX = position.x
        var newY = position.y
        commands.forEach {
            if (it == MOVE_FORWARD) {
                when (direction) {
                    N -> newY += 1
                    S -> newY -= 1
                    E -> newX += 1
                    else -> newX -= 1
                }
            } else {
                newY -= 1
            }
        }
        position = Coordinate(newX, newY)
    }

}
