package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CustomerRepositoryTest {
    @Test
    fun `should store a new customer`() {
        val customerRepository = CustomerRepository()
        val customer = Customer(name = "John Doe", email = "jdoe@mail.com", password = "Abcd_1234")

        customerRepository.create(customer)

        assertThat(customerRepository.getAll()).containsExactly(customer)
    }
}
