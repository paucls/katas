package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DirectoryTest {

    private val directory = Directory("dir1")

    @Test
    fun `should have a name`() {
        assertThat(directory.name).isEqualTo("dir1")
    }

    @Test
    fun `should allow adding a file`() {
        val aFile = File("file1", 100)

        directory.add(aFile)

        assertThat(directory.list()).contains(aFile)
    }

    @Test
    fun `should allow adding a directory`() {
        val anotherDirectory = Directory("dir2")

        directory.add(anotherDirectory)

        assertThat(directory.list()).contains(anotherDirectory)
    }
}
