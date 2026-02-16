package com.katas.supermarket.api

import com.katas.supermarket.app.services.CheckoutService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class ChangeMeController(private val checkoutService: CheckoutService) {

    @PostMapping("/checkout")
    fun checkout(@RequestBody request: CheckoutRequest): ResponseEntity<Any> {
        if (request.skus.isEmpty()) {
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }

        val total = checkoutService.checkout(request.skus)
        return ResponseEntity.status(HttpStatus.CREATED).body(CheckoutResponse(total))
    }
}

data class CheckoutRequest(
    val skus: List<String> = emptyList(),
)

data class CheckoutResponse(
    val total: BigDecimal,
)