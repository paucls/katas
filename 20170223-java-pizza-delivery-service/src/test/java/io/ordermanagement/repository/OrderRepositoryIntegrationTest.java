package io.ordermanagement.repository;

import io.ordermanagement.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryIntegrationTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void testFindAll() {
        Order order = new Order();
        order.setName("John Doe");
        this.entityManager.persist(order);

        List<Order> taskList = orderRepository.findAll();

        assertThat(taskList.size(), is(1));
        assertThat(taskList.get(0).getName(), is("John Doe"));
    }

}
