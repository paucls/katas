package com.katas

fun main(args: Array<String>) {
    val fileWriter = FileWriter()
    val fileLogger = FileLogger(fileWriter, DateProvider)

    fileLogger.log("A message!")
}
