package com.katas

class Game {
    private val numFrames = 10
    private var rolls: MutableList<Int> = mutableListOf()

    fun roll(pins: Int) {
        rolls.add(pins)
    }

    fun score(): Int {
        var score = 0
        var rollIndex = 0

        repeat(numFrames) {
            if (isStrike(rollIndex)) {
                score += rolls[rollIndex] + rolls[rollIndex + 1] + rolls[rollIndex + 2]

                rollIndex += 1
            } else {
                score += rolls[rollIndex] + rolls[rollIndex + 1]

                if (isSpare(rollIndex)) {
                    score += rolls[rollIndex + 2]
                }

                rollIndex += 2
            }
        }

        return score
    }

    private fun isStrike(rollIndex: Int) = rolls[rollIndex] == 10

    private fun isSpare(rollIndex: Int) = rolls[rollIndex] + rolls[rollIndex + 1] == 10
}
