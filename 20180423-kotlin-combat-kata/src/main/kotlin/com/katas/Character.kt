package com.katas

class Character {
    var health: Int = 1000
    var level: Int = 1
    var isAlive: Boolean = true

    fun receiveDamage(damage: Int) {
        this.health -= damage
    }
}
