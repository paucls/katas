package com.katas

private const val maxCharacterHealth = 1000
private const val deadCharacterHealth = 0

class Character(
        var health: Int = maxCharacterHealth,
        var level: Int = 1,
        var isAlive: Boolean = true
) {

    fun damage(receiver: Character, amount: Int) {
        if (this === receiver) throw CannotDamageItself()

        receiver.receiveDamage(amount)
    }

    private fun receiveDamage(damage: Int) {
        if (damage > health) {
            health = deadCharacterHealth
            isAlive = false
        } else {
            health -= damage
        }
    }

    fun heal(receiver: Character, amount: Int) {
        if (this !== receiver) throw CannotHealOthers()

        receiver.receiveHeal(amount)
    }

    private fun receiveHeal(amount: Int) {
        if (!isAlive) throw CannotHealDeadWhenDead()

        if (health + amount > maxCharacterHealth) {
            health = maxCharacterHealth
        } else {
            health += amount
        }
    }

}
