package com.katas

class StringCalculator {
    fun add(command: String): Int {
        var delimiter = ","
        var numbers = command

        if(command.startsWith("//")) {
            delimiter = extractDelimiter(command)
            numbers = extractNumbers(command)
        }

        return numbers
                .split(delimiter, "\n")
                .map(::numberToInt)
                .reduce { acc, next -> acc + next }
    }

    private fun extractNumbers(command: String) = command.substring(2)

    private fun extractDelimiter(command: String) = command.substring(2, 3)

    private fun numberToInt(number: String): Int {
        return if (number.isEmpty()) 0
        else number.toInt()
    }
}
