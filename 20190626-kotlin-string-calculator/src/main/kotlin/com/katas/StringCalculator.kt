package com.katas

class StringCalculator {
    fun add(rawCommand: String): Int {
        var numbers = rawCommand
        val command = Command(rawCommand)

        if (rawCommand.startsWith("//")) {
            numbers = extractNumbers(rawCommand)
        }

        return numbers
                .split(command.delimiter, "\n")
                .map(::numberToInt)
                .reduce { acc, next -> acc + next }
    }

    private fun extractNumbers(command: String) = command.substring(2)

    private fun numberToInt(number: String): Int {
        return if (number.isEmpty()) 0
        else number.toInt()
    }
}

class Command(var text: String) {
    val delimiter: String
        get() {
            if (text.startsWith("//")) {
                return text.substring(2, 3)
            }
            return ","
        }
}
