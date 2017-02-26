package io.ordermanagement.api;

import io.ordermanagement.model.Money;
import io.ordermanagement.model.Product;
import io.ordermanagement.repository.ProductRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductsApiControllerWebIntegrationTest {

    private static String URL = "/products/";

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    private Product product;

    @Before
    public void setup() {
        product = new Product();
        product.setName("Pizza Margherita");
        product.setDescription("Made with tomatoes, sliced mozzarella, basil, and extra virgin olive oil.");
        product.setPrice(new Money(new BigDecimal("7.5"), "EURO"));
    }

    @After
    public void tearDown() {
        productRepository.deleteAll();
    }

    @Test
    public void testGetAllProducts() {
        productRepository.saveAndFlush(product);

        Product[] response = restTemplate.getForObject(URL, Product[].class);
        List<Product> allProducts = Arrays.asList(response);

        assertThat(allProducts, hasSize(1));
        assertThat(allProducts.get(0).getId(), notNullValue());
        assertThat(allProducts.get(0).getName(), is("Pizza Margherita"));
    }

    @Test
    public void testCreateProduct() {
        HttpEntity<Product> request = new HttpEntity<>(product);

        Product createdProduct = restTemplate.postForObject(URL, request, Product.class);

        assertThat(createdProduct, notNullValue());
        assertThat(createdProduct.getId(), notNullValue());
        assertThat(createdProduct.getName(), is("Pizza Margherita"));
        assertThat(createdProduct.getPrice().getAmount(), is(new BigDecimal("7.5")));
        assertThat(createdProduct.getPrice().getCurrency(), is("EURO"));
    }

}
