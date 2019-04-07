package com.katas

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class CustomerRegistrationServiceTest {

    private val customersRepository: CustomerRepository = mock()
    private val emailSender: EmailSender = mock()
    private val customerRegistrationService = CustomerRegistrationService(customersRepository, emailSender)

    private val registrationRequest = RegistrationRequest(name = "John Doe", address = "jdoe@mail.com", password = "Abcd_1234")
    private val customer = Customer(name = "John Doe", email = "jdoe@mail.com", password = "Abcd_1234")

    @Test
    fun `should store customer on repository`() {
        customerRegistrationService.register(registrationRequest)

        verify(customersRepository).create(customer)
    }

    @Test
    fun `should send welcome email to customer`() {
        customerRegistrationService.register(registrationRequest)

        verify(emailSender).send(customer.email, "Welcome John Doe!")
    }
}
