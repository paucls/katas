package com.katas

class Game {
    private var rolls: MutableList<Int> = mutableListOf()

    fun roll(pins: Int) {
        rolls.add(pins)
    }

    fun score(): Int {
        var score = 0

        for (i in 0..19 step 2) {
            if (isSpare(i)) {
                score += rolls[i + 2]
            }
            score += rolls[i] + rolls[i + 1]
        }

        return score
    }

    private fun isSpare(i: Int) = rolls[i] + rolls[i + 1] == 10
}
