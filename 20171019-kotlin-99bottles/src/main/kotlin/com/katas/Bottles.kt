package com.katas

class Bottles {

    fun song(): String = verses(99, 0)

    fun verses(start: Int, end: Int): String {
        return (start downTo end)
                .map { verse(it) }
                .joinToString("\n\n")
    }

    fun verse(number: Int): String {
        val nextNumber = number - 1
        val suffix = suffix(number)
        val nextSuffix = suffix(nextNumber)

        return when (number) {
            0 ->
                """
                No more bottles of beer on the wall, no more bottles of beer.
                Go to the store and buy some more, 99 bottles of beer on the wall.
                """
            1 ->
                """
                1 bottle of beer on the wall, 1 bottle of beer.
                Take it down and pass it around, no more bottles of beer on the wall.
                """
            else ->
                """
                $number bottle$suffix of beer on the wall, $number bottle$suffix of beer.
                Take one down and pass it around, $nextNumber bottle$nextSuffix of beer on the wall.
                """
        }.trimIndent()

    }

    private fun suffix(number: Int): String = if (number > 1) "s" else ""
}
