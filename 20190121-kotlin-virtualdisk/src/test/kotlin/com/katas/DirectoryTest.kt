package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DirectoryTest {
    @Test
    fun `should allow adding a file`() {
        val directory = Directory("dir1")
        val newFile = File()

        directory.addFile(newFile)

        assertThat(directory.files).contains(newFile)
    }
}