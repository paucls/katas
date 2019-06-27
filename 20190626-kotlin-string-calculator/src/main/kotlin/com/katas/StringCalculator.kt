package com.katas

class StringCalculator {
    fun add(rawCommand: String): Int {
        val command = Command(rawCommand)

        return command.numbers
                .split(command.delimiter, "\n")
                .map(::numberToInt)
                .reduce { acc, next -> acc + next }
    }

    private fun numberToInt(number: String): Int {
        return if (number.isEmpty()) 0
        else number.toInt()
    }
}

class Command(var text: String) {

    val delimiter: String
        get() = when {
            hasCustomDelimiter() -> text.substring(2, 3)
            else -> ","
        }

    val numbers: String
        get() = when {
            hasCustomDelimiter() -> text.substring(2)
            else -> text
        }

    private fun hasCustomDelimiter() = text.startsWith("//")
}
