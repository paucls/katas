package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class StorageTest {
    @Test
    fun `should have a root directory`() {
        val storage = Storage()

        val directory = storage.rootDirectory()

        assertThat(directory).isEqualTo(Directory("/"))
    }
}