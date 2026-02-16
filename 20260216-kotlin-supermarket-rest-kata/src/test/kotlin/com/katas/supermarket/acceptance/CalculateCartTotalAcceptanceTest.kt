package com.katas.supermarket.acceptance


import com.katas.supermarket.app.domain.Product
import com.katas.supermarket.app.domain.ProductRepository
import net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.web.client.RestTemplate
import java.math.BigDecimal

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculateCartTotalAcceptanceTest {

    @LocalServerPort
    private var port: Int = 0

    @Autowired
    private lateinit var restTemplate: RestTemplate

    @Autowired
    private lateinit var productRepository: ProductRepository

    @Test
    fun `should calculate the total of the cart given a list of SKUs`() {
        // Given
        productRepository.save(Product("A", BigDecimal("2.00"), "Milk"))
        productRepository.save(Product("B", BigDecimal("4.00"), "Orange Juice"))

        // When
        val requestBody =
                """
					{ 
						"skus": ["A","B","A","B","A","A","A"] 
					}
				"""
        val headers = HttpHeaders().apply {
            contentType = org.springframework.http.MediaType.APPLICATION_JSON
        }
        val responseEntity = restTemplate.exchange(
                "http://localhost:$port/checkout",
                HttpMethod.POST,
                HttpEntity(requestBody, headers),
                String::class.java
        )

        // Then
        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.CREATED)
        assertThatJson(responseEntity.body).isEqualTo("""
                { "total": 18.00 }
                """)
    }
}
