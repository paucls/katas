package io.ordermanagement.api;

import io.ordermanagement.model.Order;
import io.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class OrdersApiController implements OrdersApi {

    private OrderRepository orderRepository;

    @Autowired
    public OrdersApiController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderRepository.saveAndFlush(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

}
