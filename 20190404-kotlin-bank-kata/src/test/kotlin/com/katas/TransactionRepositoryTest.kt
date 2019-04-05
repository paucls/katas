package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.time.LocalDate

class TransactionRepositoryTest {
    @Test
    fun `save should store transaction`() {
        val transactionRepository = TransactionRepository()
        val transaction = Transaction(LocalDate.now(), 100)

        transactionRepository.save(transaction)

        assertThat(transactionRepository.getAccountTransactions()).containsExactly(transaction)
    }
}
