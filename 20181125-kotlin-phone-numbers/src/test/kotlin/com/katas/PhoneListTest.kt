package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PhoneListTest {

    @Test
    fun `should be consistent when is empty`() {
        val phoneList = PhoneList()

        assertThat(phoneList.isConsistent()).isTrue()
    }

    @Test
    fun `should be consistent when has a single phone number`() {
        val phoneList = PhoneList.of("91125426")

        assertThat(phoneList.isConsistent()).isTrue()
    }

    @Test
    fun `should not be consistent when a number is prefix of another one`() {
        val phoneList = PhoneList.of("91125426", "911")

        assertThat(phoneList.isConsistent()).isFalse()
    }
}