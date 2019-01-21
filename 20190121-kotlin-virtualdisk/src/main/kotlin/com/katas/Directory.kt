package com.katas

data class Directory(val name: String) {
    val files: MutableList<File> = mutableListOf()

    fun addFile(file: File) {
        files.add(file)
    }
}
