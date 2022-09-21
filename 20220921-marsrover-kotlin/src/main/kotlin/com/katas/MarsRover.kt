package com.katas

private const val BACKWARD_COMMAND = 'b'

class MarsRover(var position: Position) {
    fun receiveCommand(commands: String) {
        commands.forEach { command ->
            if (command == BACKWARD_COMMAND) {
                moveBackward()
            } else {
                moveForward()
            }
        }
    }

    private fun moveForward() {
        position = Position(0, position.y + 1)
    }

    private fun moveBackward() {
        position = Position(0, position.y - 1)
    }
}
