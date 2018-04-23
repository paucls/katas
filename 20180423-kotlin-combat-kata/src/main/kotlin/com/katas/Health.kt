package com.katas

data class Health(private val points: Int = 1000) : Comparable<Health> {

    private val maxPoints = 1000
    private val minPoints = 0

    fun plus(amount: Int): Health {
        if (this.points + amount > maxPoints) {
            return Health(maxPoints)
        }
        return Health(this.points + amount)
    }

    fun minus(amount: Int): Health {
        if (this.points - amount < minPoints) {
            return Health(minPoints)
        }
        return Health(this.points - amount)
    }

    fun isEmpty(): Boolean = points == 0

    override fun compareTo(other: Health): Int {
        return compareValuesBy(this, other, Health::points)
    }
}