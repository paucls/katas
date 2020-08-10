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
    fun `should calculate the total size used by its contents`() {
        storage.rootDirectory().add(File(name = "file1", size = 100))
        val directory = Directory("dir1")
        directory.add(File(name = "file2", size = 50))
        storage.rootDirectory().add(directory)

        assertThat(storage.totalSize()).isEqualTo(150)
    }

    @Test
    fun `should calculate the total size used when is empty`() {
        assertThat(storage.totalSize()).isZero()
    }

    @Test
    fun `should count the total number of mp3 files`() {
        storage.rootDirectory().add(File(name = "file1.mp3", size = 1))
        storage.rootDirectory().add(File(name = "file2.txt", size = 2))

        assertThat(storage.totalMP3()).isOne()
    }
}