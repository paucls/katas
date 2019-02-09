package com.katas

class Game {
    private var score: Int = 0

    fun score(): Int {
        return score
    }

    fun roll(pins: Int) {
        score = pins
    }
}
