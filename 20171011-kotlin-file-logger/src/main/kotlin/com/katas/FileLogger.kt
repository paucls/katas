package com.katas

class FileLogger(
        private val fileWriter: FileWriter,
        private val dateProvider: DateProvider) {

    private val dateFormat = "yyyyMMdd"

    fun log(message: String) {
        val currentDate = dateProvider.currentDate(dateFormat)
        val fileName = "log$currentDate.txt"

        if (fileWriter.exist(fileName))
            fileWriter.appendText(fileName, message)
        else
            fileWriter.writeText(fileName, message)
    }
}