package com.katas

data class Directory(val name: String): Resource {
    private val contents: MutableList<Resource> = mutableListOf()

    fun list(): List<Resource> {
        return contents.toList()
    }

    fun add(file: Resource) {
        contents.add(file)
    }
}
