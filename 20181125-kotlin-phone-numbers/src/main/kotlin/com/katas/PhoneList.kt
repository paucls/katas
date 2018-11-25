package com.katas

class PhoneList(private val phoneNumbers: List<String> = emptyList()) {
    fun isConsistent(): Boolean {
        return !phoneNumbers.any { phoneX ->
            phoneNumbers
                    .filter { it != phoneX }
                    .any { phoneY -> phoneY.contains(phoneX) }
        }
    }
}
