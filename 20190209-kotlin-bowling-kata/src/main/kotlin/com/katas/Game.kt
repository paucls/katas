package com.katas

class Game {
    private val numFramesOnGame = 10
    private val numPinsOnFrame = 10

    private var rolls: MutableList<Int> = mutableListOf()

    fun roll(pins: Int) {
        rolls.add(pins)
    }

    fun score(): Int {
        var score = 0
        var rollIndex = 0

        repeat(numFramesOnGame) {
            when {
                isStrike(rollIndex) -> {
                    score += rolls[rollIndex] + rolls[rollIndex + 1] + rolls[rollIndex + 2]
                    rollIndex += 1
                }
                isSpare(rollIndex) -> {
                    score += rolls[rollIndex] + rolls[rollIndex + 1] + rolls[rollIndex + 2]
                    rollIndex += 2
                }
                else -> {
                    score += rolls[rollIndex] + rolls[rollIndex + 1]
                    rollIndex += 2
                }
            }
        }

        return score
    }

    private fun isStrike(rollIndex: Int) = rolls[rollIndex] == numPinsOnFrame

    private fun isSpare(rollIndex: Int) = rolls[rollIndex] + rolls[rollIndex + 1] == numPinsOnFrame
}
