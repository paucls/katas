package com.katas

class Game {
    private val numFrames = 10
    private var rolls: MutableList<Int> = mutableListOf()

    fun roll(pins: Int) {
        rolls.add(pins)
    }

    fun score(): Int {
        var score = 0

        repeat(numFrames) {
            score += rolls[it] + rolls[it + 1]
        }

        return score
    }
}
