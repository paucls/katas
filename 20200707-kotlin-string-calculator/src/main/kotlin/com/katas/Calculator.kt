package com.katas

class Calculator {
    private val newLine = "\n"
    private val defaultDelimiter = ","
    private val changeDelimiterPrefix = "//"

    fun add(command: String): Int {
        if (command.isEmpty()) return 0

        var numbers = command
        var delimiters = arrayOf(newLine, defaultDelimiter)

        if (definesCustomDelimiter(command)) {
            delimiters = arrayOf(getCustomDelimiter(command), newLine)
            numbers = command.split(newLine)[1]
        }

        return numbers
                .split(*delimiters)
                .map(String::toInt)
                .sum()
    }

    private fun definesCustomDelimiter(numbers: String) =
            numbers.startsWith(changeDelimiterPrefix)

    private fun getCustomDelimiter(numbers: String) =
            numbers.substring(2).split(newLine)[0]
}
