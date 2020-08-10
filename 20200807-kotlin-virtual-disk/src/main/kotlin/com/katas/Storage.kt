package com.katas

class Storage {

    private val rootDirectory = Directory("/")

    fun rootDirectory(): Directory {
        return rootDirectory
    }

    fun totalSize(): Int {
        return rootDirectory.size()
    }

    fun totalMP3(): Int {
        var total = 0

        rootDirectory.list().forEach { resource ->
            if (resource is File && resource.name.endsWith("mp3")) total++
        }

        return total
    }
}
