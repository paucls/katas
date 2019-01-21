package com.katas

data class Directory(val name: String): Resource() {
    val resources: MutableList<Resource> = mutableListOf()

    fun add(resource: Resource) {
        resources.add(resource)
    }

    fun delete(resource: Resource) {
        resources.remove(resource)
    }
}
