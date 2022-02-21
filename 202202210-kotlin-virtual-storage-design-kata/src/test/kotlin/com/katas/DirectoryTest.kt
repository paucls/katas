package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class DirectoryTest {
    @Test
    internal fun `should allow adding a file`() {
        val directory = Directory("dir1")
        val file = File("file1", 100)

        directory.addFile(file)

        assertThat(directory.getFiles()).containsExactly(file)
    }

    @Test
    internal fun `should allow deleting a file`() {
        val file1 = File("file1", 100)
        val file2 = File("file2", 200)
        val directory = Directory(name = "dir1", files = setOf(file1, file2))

        directory.deleteFile(file1)

        assertThat(directory.getFiles()).containsExactly(file2)
    }
}