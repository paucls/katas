package io.ordermanagement.repository;

import io.ordermanagement.model.Product;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryIntegrationTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void testFindAll() {
        Product product = new Product();
        product.setName("Pizza Margherita");
        product.setPrice(new BigDecimal("7.5"));
        product.setCurrency("EURO");
        this.entityManager.persist(product);

        List<Product> allProducts = productRepository.findAll();

        assertThat(allProducts.size(), is(1));
        assertThat(allProducts.get(0).getName(), is("Pizza Margherita"));
        assertThat(allProducts.get(0).getPrice(), CoreMatchers.is(new BigDecimal("7.5")));
    }

}
