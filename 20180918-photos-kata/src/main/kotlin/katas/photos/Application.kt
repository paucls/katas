package katas.photos

class Application {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            if (args.isEmpty()) {
                println("Please, provide a folder path.")
                return
            }

            val fileSystem = FileSystemImpl()
            val photosService = PhotosService(fileSystem)

            println("Listing duplicated photos in ${args[0]}")
            photosService.listDuplicates(args[0]).forEach(::println)
        }

    }
}