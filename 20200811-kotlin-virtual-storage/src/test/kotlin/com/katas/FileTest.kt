package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileTest {

    @Test
    fun `should have a name and size`() {
        val file = File("file1", 100)
        assertThat(file.name).isEqualTo("file1")
        assertThat(file.size).isEqualTo(100)
    }
}
