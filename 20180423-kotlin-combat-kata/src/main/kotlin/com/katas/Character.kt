package com.katas

class Character(
        var health: Health = Health(),
        var level: Int = 1,
        var isAlive: Boolean = true
) {

    fun damage(receiver: Character, amount: Int) {
        if (this === receiver) throw CannotDamageItself()

        if (receiver.level - level >= 5) {
            receiver.receiveDamage(amount / 2)
        } else if (level - receiver.level >= 5) {
            receiver.receiveDamage(amount * 2)
        } else {
            receiver.receiveDamage(amount)
        }
    }

    fun heal(receiver: Character, amount: Int) {
        if (this !== receiver) throw CannotHealOthers()

        receiver.receiveHeal(amount)
    }

    private fun receiveDamage(damage: Int) {
        health = health.minus(damage)

        if (health.isEmpty()) {
            isAlive = false
        }
    }

    private fun receiveHeal(amount: Int) {
        if (!isAlive) throw CannotHealWhenDead()

        health = health.plus(amount)
    }

}
