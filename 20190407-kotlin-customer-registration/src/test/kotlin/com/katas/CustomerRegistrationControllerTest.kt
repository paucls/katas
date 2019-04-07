package com.katas

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CustomerRegistrationControllerTest {
    val registrationService: CustomerRegistrationService = mock()
    val registrationController = CustomerRegistrationController(registrationService)
    val registrationRequest = RegistrationRequest(
            name = "John Doe",
            address = "jdoe@mail.com",
            password = "Abcd_1234")

    @Test
    fun `should call register customer`() {
        registrationController.post(registrationRequest)

        verify(registrationService).register(registrationRequest)
    }

    @Test
    fun `should return 204 status code on success`() {
        val response = registrationController.post(registrationRequest)

        assertThat(response).isEqualTo(204)
    }
}
