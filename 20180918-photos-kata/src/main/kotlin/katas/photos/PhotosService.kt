package katas.photos

class PhotosService(private val fileSystem: FileSystem) {

    fun listDuplicates(path: String): List<String> {
        val files = this.fileSystem.listFiles(path)

        return files.groupBy { it.name }
                .filterValues { it.size > 1 }
                .values.flatten()
                .map { it.fullName }
    }

    fun deleteDuplicatesWithExtension(path: String, extension: String) {
        val files = this.fileSystem.listFiles(path)

        files.groupBy { it.name }
                .filterValues { it.size > 1 }
                .values.flatten()
                .filter { it.extension == extension }
                .forEach { fileSystem.delete(it) }
    }
}
