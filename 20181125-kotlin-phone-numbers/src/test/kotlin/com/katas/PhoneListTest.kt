package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PhoneListTest {

    @Test
    fun `should be consistent when is empty`() {
        val phoneList = PhoneList()

        val isConsistent = phoneList.isConsistent()

        assertThat(isConsistent).isTrue()
    }
}