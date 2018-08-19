package katas.photos

data class File(
        val path: String,
        val name: String,
        val extension: String
) {
    val fullName: String
        get() = "$name.$extension"
}