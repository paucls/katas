package com.katas

data class Directory(
        override val name: String
): Resource {
    private val resources = mutableListOf<Resource>()

    fun list(): List<Resource> {
        return resources.toList()
    }

    fun add(resource: Resource) {
        resources.add(resource)
    }
}
