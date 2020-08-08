package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StorageTest {
    @Test
    internal fun `should have a root directory`() {
        val storage = Storage()
        assertThat(storage.rootDirectory()).isEqualTo(Directory("/"))
    }
}