package com.katas

data class File(val name: String, val size: Int) : Resource {
    override fun size() = size
}
