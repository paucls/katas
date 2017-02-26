package io.ordermanagement.api;

import io.ordermanagement.model.Order;
import io.ordermanagement.repository.OrderRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OrdersApiControllerWebIntegrationTest {

    private static String URL = "/orders/";

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @After
    public void tearDown() {
        orderRepository.deleteAll();
    }

    @Test
    public void testGetAllOrders() {
        Order order = new Order();
        order.setName("Jack Sparrow");
        orderRepository.saveAndFlush(order);

        Order[] response = restTemplate.getForObject(URL, Order[].class);
        List<Order> allOrders = Arrays.asList(response);

        assertThat(allOrders, hasSize(1));
        assertThat(allOrders.get(0).getId(), notNullValue());
        assertThat(allOrders.get(0).getName(), is("Jack Sparrow"));
    }

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        order.setName("John Doe");
        HttpEntity<Order> request = new HttpEntity<>(order);

        Order createdOrder = restTemplate.postForObject(URL, request, Order.class);

        assertThat(createdOrder, notNullValue());
        assertThat(createdOrder.getId(), notNullValue());
        assertThat(createdOrder.getName(), is("John Doe"));
    }

}
