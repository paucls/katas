package com.katas

class CustomerRegistrationService(private val customersRepository: CustomerRepository) {
    fun register(request: RegistrationRequest) {
        val customer = Customer(request.name, request.address, request.password)
        customersRepository.create(customer)
    }
}
