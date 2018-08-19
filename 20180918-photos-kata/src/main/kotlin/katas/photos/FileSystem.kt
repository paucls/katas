package katas.photos

interface FileSystem {
    fun listFiles(path: String): Set<File>

    fun delete(path: File)
}
