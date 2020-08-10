package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class DirectoryTest {

    private val directory = Directory("dir1")

    @Test
    internal fun `should allow adding a file`() {
        val file = File("file1", 100)

        directory.add(file)

        assertThat(directory.list()).contains(file)
    }

    @Test
    internal fun `should allow adding a directory`() {
        val subdirectory = Directory("subdirectory")

        directory.add(subdirectory)

        assertThat(directory.list()).contains(subdirectory)
    }

    @Test
    fun `should calculate its size`() {
        val directory = Directory("dir1")
        directory.add(File(name = "file1", size = 10))
        directory.add(File(name = "file1", size = 20))

        assertThat(directory.size()).isEqualTo(30)
    }
}