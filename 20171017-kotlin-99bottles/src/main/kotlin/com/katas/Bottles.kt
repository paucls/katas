package com.katas

class Bottles {

    fun verse(number: Int): String {

        val numberBottles = "$number ${bottles(number)}"
        val nextNumber = number - 1
        val nextNumberBottles = "$nextNumber ${bottles(nextNumber)}"

        return when (nextNumber) {
            0 -> """
                $numberBottles of beer on the wall, $numberBottles of beer.
                Take it down and pass it around, no more bottles of beer on the wall.
            """.trimIndent()

            else -> """
                $numberBottles of beer on the wall, $numberBottles of beer.
                Take one down and pass it around, $nextNumberBottles of beer on the wall.
            """.trimIndent()
        }
    }

    fun bottles(number: Int): String = if (number > 1) "bottles" else "bottle"

}
