package com.katas

data class Directory(val name: String): Resource {

    private val contents: MutableList<Resource> = mutableListOf()

    override fun size(): Int {
        var total = 0

        contents.forEach { total += it.size() }

        return total
    }

    fun list(): List<Resource> {
        return contents.toList()
    }

    fun add(file: Resource) {
        contents.add(file)
    }
}
