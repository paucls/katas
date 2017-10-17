package com.katas

class Bottles {

    fun verse(number: Int): String {
        return """
                $number bottles of beer on the wall, $number bottles of beer.
                Take one down and pass it around, ${number - 1} bottles of beer on the wall.
            """.trimIndent()
    }

}
