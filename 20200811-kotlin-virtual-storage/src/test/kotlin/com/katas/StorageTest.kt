package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StorageTest {

    private val storage = Storage()

    @Test
    fun `should return the base directory as root directory`() {
        assertThat(storage.rootDirectory()).isEqualTo(Directory("/"))
    }

    @Test
    fun `should calculate total size`() {
        storage.rootDirectory().add(File("file1", 10))
        storage.rootDirectory().add(File("file2", 20))

        assertThat(storage.totalSize()).isEqualTo(30)
    }
}
