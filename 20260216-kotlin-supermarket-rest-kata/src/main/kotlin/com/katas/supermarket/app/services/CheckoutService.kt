package com.katas.supermarket.app.services

import com.katas.supermarket.app.domain.ProductRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class CheckoutService(private val productRepository: ProductRepository) {
    fun checkout(skus: List<String>): BigDecimal {
        if (skus.isEmpty()) return BigDecimal.ZERO

        val productsBySku = productRepository.findAllById(skus.distinct()).associateBy { it.sku }
        return skus.fold(BigDecimal.ZERO) { acc, sku ->
            acc + (productsBySku[sku]?.price ?: BigDecimal.ZERO)
        }
    }
}