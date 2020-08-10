package com.katas

class Storage {

    private val rootDirectory = Directory("/")

    fun rootDirectory(): Directory {
        return rootDirectory
    }

    fun totalSize(): Int {
        return rootDirectory.size()
    }
}
