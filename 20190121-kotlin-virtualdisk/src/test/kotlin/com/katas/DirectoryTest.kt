package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DirectoryTest {

    private val file = File("file1.ext")

    @Test
    fun `should allow adding a file`() {
        val directory = Directory("dir1")

        directory.add(file)

        assertThat(directory.files).contains(file)
    }

    @Test
    fun `should allow deleting an existing file`() {
        val directory = Directory("dir1")
        directory.add(file)

        directory.delete(file)

        assertThat(directory.files).doesNotContain(file)
    }
}