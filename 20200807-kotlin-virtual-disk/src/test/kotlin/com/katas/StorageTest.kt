package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StorageTest {

    private val storage = Storage()

    @Test
    fun `should have a root directory`() {
        assertThat(storage.rootDirectory()).isEqualTo(Directory("/"))
    }

    @Test
    fun `should indicate the total size used by its contents`() {
        storage.rootDirectory().add(File(name = "file1", size = 100))
        storage.rootDirectory().add(File(name = "file2", size = 50))

        assertThat(storage.totalSize()).isEqualTo(150)
    }
}