package com.katas

class Storage {

    private val rootDirectory = Directory("/")

    fun rootDirectory(): Directory {
        return rootDirectory
    }

    fun totalSize(): Int {
        var total = 0
        rootDirectory()
                .list()
                .forEach { total += it.size() }
        return total
    }
}
