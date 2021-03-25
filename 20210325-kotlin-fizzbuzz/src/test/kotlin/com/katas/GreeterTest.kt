package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GreeterTest {
    @Test
    internal fun `should say hello`() {
        val greeter = Greeter("John Doe")

        assertThat(greeter.sayHello()).isEqualTo("Hello, John Doe!")
    }
}