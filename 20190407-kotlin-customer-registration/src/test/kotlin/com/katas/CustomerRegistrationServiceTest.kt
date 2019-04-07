package com.katas

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class CustomerRegistrationServiceTest {
    @Test
    fun `should store customer on repository`() {
        val customersRepository: CustomerRepository = mock()
        val customerRegistrationService = CustomerRegistrationService(customersRepository)
        val registrationRequest = RegistrationRequest(name = "John Doe", address = "jdoe@mail.com", password = "Abcd_1234")
        val customer = Customer(name = "John Doe", email = "jdoe@mail.com", password = "Abcd_1234")

        customerRegistrationService.register(registrationRequest)

        verify(customersRepository).create(customer)
    }
}
