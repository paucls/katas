package com.katas

import java.io.File

class FileWriter {
    fun appendText(fileName: String, text: String) {
        File(fileName).appendText(text)
    }

    fun writeText(fileName: String, text: String) {
        File(fileName).writeText(text)
    }

    fun exist(fileName: String): Boolean {
        return false
    }
}