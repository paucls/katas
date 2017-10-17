package com.katas

class Bottles {

    fun verse(number: Int): String {

        val nextNumber = number - 1

        return """
                $number bottles of beer on the wall, $number bottles of beer.
                Take one down and pass it around, $nextNumber bottle${if (nextNumber > 1) "s" else ""} of beer on the wall.
            """.trimIndent()
    }

}
