package com.katas

class FileLogger(val fileWriter: FileWriter) {
    fun log(message: String) {
        fileWriter.appendText("log.txt", message)
    }
}