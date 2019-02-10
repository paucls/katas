package com.katas

class Game {
    private var rolls: MutableList<Int> = mutableListOf()

    fun roll(pins: Int) {
        rolls.add(pins)
    }

    fun score(): Int {
        var score = 0
        var rollIndex = 0

        for (frameIndex in 0..9) {
            if (rolls[rollIndex] == 10) {
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

    private fun isSpare(i: Int) = rolls[i] + rolls[i + 1] == 10
}
