package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DirectoryTest {

    private val file = File("file1.ext")

    @Test
    fun `should allow adding a file`() {
        val directory = Directory("dir1")

        directory.add(file)

        assertThat(directory.resources).contains(file)
    }

    @Test
    fun `should allow adding a directory`() {
        val directory1 = Directory("dir1")
        val directory2 = Directory("dir1")

        directory1.add(directory2)

        assertThat(directory1.resources).contains(directory2)
    }

    @Test
    fun `should allow deleting an existing file`() {
        val directory = Directory("dir1")
        directory.add(file)

        directory.delete(file)

        assertThat(directory.resources).doesNotContain(file)
    }

    @Test
    fun `should allow deleting a directory`() {
        val directory1 = Directory("dir1")
        val directory2 = Directory("dir1")
        directory1.add(directory2)

        directory1.delete(directory2)

        assertThat(directory1.resources).doesNotContain(directory2)
    }
}