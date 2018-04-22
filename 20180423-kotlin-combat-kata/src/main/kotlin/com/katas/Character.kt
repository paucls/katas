package com.katas

class Character(
        var health: Int = 1000,
        var level: Int = 1,
        var isAlive: Boolean = true
) {
    fun damage(other: Character, amount: Int) {
        if (this === other) {
            throw CannotDamageItself()
        }

        other.receiveDamage(amount)
    }

    private fun receiveDamage(damage: Int) {
        if (damage > health) {
            health = 0
            isAlive = false
        } else {
            health -= damage
        }
    }

    fun receiveHeal(amount: Int) {
        if (!isAlive) throw CannotHealDeadWhenDead()

        if (health + amount > 1000) {
            health = 1000
        } else {
            health += amount
        }
    }

}
