package com.katas

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class StorageTest {

    @Test
    internal fun `should have a root directory`() {
        val storage = Storage()
        val rootDirectory = Directory("/")

        assertThat(storage.getRootDirectory()).isEqualTo(rootDirectory)
    }
}