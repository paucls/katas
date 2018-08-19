package katas.photos

class Application {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            if (args.isEmpty() || args.size < 2) {
                println("Usage:")
                println("photos --list path")
                println("photos --delete path extension")
                return
            }

            val fileSystem = FileSystemImpl()
            val photosService = PhotosService(fileSystem)

            if (args[0] == "--list") {
                println("Listing duplicated photos in ${args[1]}")
                photosService.listDuplicates(args[1]).forEach(::println)
            }

            if (args[0] == "--delete") {
                println("Deleting duplicated photos in ${args[1]} with extension ${args[2]}")
                photosService.deleteDuplicatesWithExtension(args[1], args[2])
            }
        }

    }
}