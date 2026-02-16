package com.katas.supermarket.app.services

import com.katas.supermarket.app.domain.Product
import com.katas.supermarket.app.domain.ProductRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.whenever
import java.math.BigDecimal

@ExtendWith(MockitoExtension::class)
class CheckoutServiceTest {

    @Mock
    private lateinit var productRepository: ProductRepository

    @InjectMocks
    private lateinit var checkoutService: CheckoutService

    @Test
    fun `should return zero when no SKUs provided`() {
        // When
        val total = checkoutService.checkout(emptyList())

        // Then
        assertThat(total).isEqualByComparingTo(BigDecimal.ZERO)
    }

    @Test
    fun `should calculate total when single SKU`() {
        // Given
        whenever(productRepository.findAllById(listOf("A")))
            .thenReturn(listOf(Product("A", BigDecimal("2.00"), "Milk")))

        // When
        val total = checkoutService.checkout(listOf("A"))

        // Then
        assertThat(total).isEqualByComparingTo(BigDecimal("2.00"))
    }

    @Test
    fun `should calculate total when two units of same SKU`() {
        // Given
        whenever(productRepository.findAllById(listOf("A")))
            .thenReturn(listOf(Product("A", BigDecimal("2.00"), "Milk")))

        // When
        val total = checkoutService.checkout(listOf("A", "A"))

        // Then
        assertThat(total).isEqualByComparingTo(BigDecimal("4.00"))
    }
}