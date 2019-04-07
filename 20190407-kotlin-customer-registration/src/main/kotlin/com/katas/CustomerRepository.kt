package com.katas

class CustomerRepository {
    private val customers = mutableListOf<Customer>()

    fun create(customer: Customer) {
        customers.add(customer)
    }

    fun getAll(): List<Customer> {
        return customers
    }
}
