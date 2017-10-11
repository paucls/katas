package com.katas

class FileLogger(private val fileWriter: FileWriter) {
    val logFileName = "log.txt"

    fun log(message: String) {
        if (fileWriter.exist(logFileName))
            fileWriter.appendText(logFileName, message)
        else
            fileWriter.writeText(logFileName, message)
    }
}