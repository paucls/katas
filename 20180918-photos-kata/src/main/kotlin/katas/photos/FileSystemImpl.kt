package katas.photos

import java.io.File

class FileSystemImpl : FileSystem {
    override fun listFiles(path: String): Set<katas.photos.File> {
        return File(path).listFiles()
                .map { katas.photos.File(it.path, it.nameWithoutExtension, it.extension) }
                .sortedBy { it.name }
                .toSet()
    }

    override fun delete(file: katas.photos.File) {
        File(file.path).delete()
    }
}