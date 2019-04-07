package com.katas

class CustomerRegistrationController(
        private val registrationService: CustomerRegistrationService
) {
    fun post(registrationRequest: RegistrationRequest): Int {
        registrationService.register(registrationRequest)
        return 204
    }
}
