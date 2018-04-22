package com.katas

private const val maxCharacterHealth = 1000
private const val deadCharacterHealth = 0

class Character(
        var health: Int = maxCharacterHealth,
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
            health = deadCharacterHealth
            isAlive = false
        } else {
            health -= damage
        }
    }

    fun heal(anotherCharacter: Character, i: Int) {
        throw CannotHealOthers()
    }

    fun receiveHeal(amount: Int) {
        if (!isAlive) throw CannotHealDeadWhenDead()

        if (health + amount > maxCharacterHealth) {
            health = maxCharacterHealth
        } else {
            health += amount
        }
    }

}
