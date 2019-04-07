package com.katas

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class CustomerRegistrationAcceptanceTest {

    private val emailSender: EmailSender = mock()
    private val customersRepository = CustomerRepository()
    private val registrationService: CustomerRegistrationService = CustomerRegistrationService(customersRepository)
    private val customerRegistrationController = CustomerRegistrationController(registrationService)

    @Test
    fun `should send welcome email to newly registered customer`() {
        val address = "jdoe@mail.com"
        val registrationRequest = RegistrationRequest(
                name = "John Doe",
                address = address,
                password = "Abcd_1234")

        customerRegistrationController.post(registrationRequest)

        verify(emailSender).send(address, "Welcome John Doe!")
    }
}
