package com.katas

class Game {
    private var rolls: MutableList<Int> = mutableListOf()

    fun score(): Int {
        return rolls.sum()
    }

    fun roll(pins: Int) {
        rolls.add(pins)
    }
}
