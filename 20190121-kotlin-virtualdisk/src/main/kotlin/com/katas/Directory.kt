package com.katas

data class Directory(val name: String) {
    val files: MutableList<File> = mutableListOf()

    fun add(file: File) {
        files.add(file)
    }

    fun delete(file: File) {
        files.remove(file)
    }
}
