package com.katas

class Bottles {

    fun song(): String = verses(99, 0)

    fun verses(from: Int, last: Int): String {
        var verses = ""

        for (i in from downTo last) {
            verses += verse(i) + "\n\n"
        }

        return verses.trim()
    }

    fun verse(number: Int): String {

        val numberBottles = "$number ${bottles(number)}"
        val nextNumber = number - 1
        val nextNumberBottles = "$nextNumber ${bottles(nextNumber)}"

        return when (number) {
            0 -> """
                No more bottles of beer on the wall, no more bottles of beer.
                Go to the store and buy some more, 99 bottles of beer on the wall.
            """.trimIndent()

            1 -> """
                $numberBottles of beer on the wall, $numberBottles of beer.
                Take it down and pass it around, no more bottles of beer on the wall.
            """.trimIndent()

            else -> """
                $numberBottles of beer on the wall, $numberBottles of beer.
                Take one down and pass it around, $nextNumberBottles of beer on the wall.
            """.trimIndent()
        }
    }

    private fun bottles(number: Int): String = if (number > 1) "bottles" else "bottle"

}
