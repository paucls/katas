package com.katas

class Directory(
        name: String,
        files: Set<Resource> = emptySet()
) : Resource(name) {
    private val _files = mutableSetOf<Resource>()

    init {
        _files.addAll(files)
    }

    fun add(file: Resource) {
        _files.add(file)
    }

    fun getFiles(): Set<Resource> {
        return _files.toSet()
    }

    fun delete(file: File) {
        _files.remove(file)
    }
}

abstract class Resource(val name: String)
