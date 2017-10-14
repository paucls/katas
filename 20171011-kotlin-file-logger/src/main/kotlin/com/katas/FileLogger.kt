package com.katas

import java.time.DayOfWeek
import java.time.format.DateTimeFormatter

class FileLogger(
        private val fileWriter: FileWriter,
        private val dateProvider: DateProvider) {

    private val dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")

    fun log(message: String) {
        val fileName = buildFileName()

        if (fileWriter.exist(fileName))
            fileWriter.appendText(fileName, message)
        else
            fileWriter.writeText(fileName, message)
    }

    private fun buildFileName(): String {
        val currentDate = dateProvider.currentDate()
        val isWeekendDay = currentDate.dayOfWeek == DayOfWeek.SATURDAY || currentDate.dayOfWeek == DayOfWeek.SUNDAY

        return if (isWeekendDay)
            "weekend.txt"
        else
            "log${currentDate.format(dateFormatter)}.txt"
    }
}