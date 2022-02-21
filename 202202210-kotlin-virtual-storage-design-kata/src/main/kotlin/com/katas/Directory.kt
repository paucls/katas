package com.katas

class Directory(
        val name: String,
        files: Set<File> = emptySet()
) {
    private val _files = mutableSetOf<File>()

    init {
        _files.addAll(files)
    }

    fun addFile(file: File) {
        _files.add(file)
    }

    fun getFiles(): Set<File> {
        return _files.toSet()
    }

    fun deleteFile(file: File) {
        _files.remove(file)
    }
}
