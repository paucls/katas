package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StorageTest {
    @Test
    internal fun `should have a root directory`() {
        val storage = Storage()
        assertThat(storage.rootDirectory()).isEqualTo(Directory("/"))
    }

    @Test
    fun `should indicate total size used`() {
        val storage = Storage()
        storage.rootDirectory().add(File(name = "file1", size = 100))
        storage.rootDirectory().add(File(name = "file2", size = 50))

        val totalSize: Int = storage.totalSize()

        assertThat(totalSize).isEqualTo(150)
    }
}