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
        return totalMP3sInDirectory(rootDirectory)
    }

    private fun totalMP3sInDirectory(directory: Directory): Int {
        return directory.list()
                .map { resource ->
                    when {
                        resource is File && resource.name.endsWith("mp3") -> 1
                        resource is Directory -> totalMP3sInDirectory(resource)
                        else -> 0
                    }
                }.sum()
    }
}
