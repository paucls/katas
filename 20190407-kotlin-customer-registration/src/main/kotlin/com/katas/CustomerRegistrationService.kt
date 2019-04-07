package com.katas

class CustomerRegistrationService(
        private val customersRepository: CustomerRepository,
        private val emailSender: EmailSender
) {
    fun register(request: RegistrationRequest) {
        val customer = Customer(request.name, request.address, request.password)

        customersRepository.create(customer)

        emailSender.send(customer.email, "Welcome ${customer.name}!")
    }
}
