package com.katas.supermarket.api

import com.katas.supermarket.app.services.CheckoutService
import org.junit.jupiter.api.Test
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.math.BigDecimal

@WebMvcTest(ChangeMeController::class)
class ChangeMeControllerIntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var checkoutService: CheckoutService

    @Test
    fun `should not calculate anything if the cart is empty of products`() {
        val result = mockMvc.perform(
            post("/checkout")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""{ "skus": [] }""")
        )

        result.andExpect(status().isNoContent)
    }

    @Test
    fun `should calculate total`() {
        whenever(checkoutService.checkout(listOf("A", "B"))).thenReturn(BigDecimal("6.00"))

        val result = mockMvc.perform(
            post("/checkout")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""{ "skus": ["A", "B"] }""")
        )

        result.andExpect(status().isCreated)
        result.andExpect(content().json("""{ "total": 6.00 }"""))
    }
}
