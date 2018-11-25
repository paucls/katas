package com.katas

class PhoneList(private val phoneNumbers: List<String> = emptyList()) {
    fun isConsistent(): Boolean {
        return phoneNumbers.none(::isPrefixOfAnother)
    }

    private fun isPrefixOfAnother(phone: String): Boolean {
        return phoneNumbers
                .filter { it != phone }
                .any { it.contains(phone) }
    }
}
