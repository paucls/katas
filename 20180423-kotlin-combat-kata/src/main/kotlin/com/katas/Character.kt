package com.katas

class Character {
    var health: Int = 1000
    var level: Int = 1
    var isAlive: Boolean = true

    fun receiveDamage(damage: Int) {
        if (damage > health) {
            health = 0
            isAlive = false
        } else {
            health -= damage
        }
    }

    fun receiveHeal(amount: Int) {
        if (health + amount > 1000) {
            health = 1000
        } else {
            health += amount
        }
    }
}
