package com.katas

class PhoneList(private val phoneNumbers: List<String> = emptyList()) {
    fun isConsistent(): Boolean {
        return phoneNumbers.none(::isPrefixOfAnother)
    }

    private fun isPrefixOfAnother(phone: String): Boolean {
        return phoneNumbers
                .minus(phone)
                .any { it.contains(phone) }
    }

    companion object {
        fun of(vararg phones: String) = PhoneList(phones.toList())
    }
}
