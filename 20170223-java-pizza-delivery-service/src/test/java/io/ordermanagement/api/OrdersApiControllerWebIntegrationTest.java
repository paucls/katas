package io.ordermanagement.api;

import io.ordermanagement.model.Order;
import io.ordermanagement.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OrdersApiControllerWebIntegrationTest {

    private static String URL = "/orders/";

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        order.setId("1");
        order.setName("John Doe");
        HttpEntity<Order> request = new HttpEntity<>(order);
        Order createdOrder = restTemplate.postForObject(URL, request, Order.class);

        assertThat(createdOrder, notNullValue());
        assertThat(createdOrder.getId(), notNullValue());
        assertThat(createdOrder.getName(), is("John Doe"));
    }

}
