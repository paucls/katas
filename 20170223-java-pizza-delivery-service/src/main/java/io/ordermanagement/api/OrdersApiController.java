package io.ordermanagement.api;

import io.ordermanagement.model.Order;
import io.ordermanagement.repository.OrderRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class OrdersApiController implements OrdersApi {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Order> createOrder(
            @ApiParam(value = "Order to create", required = true) @RequestBody Order order) {
        Order createdOrder = orderRepository.saveAndFlush(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.OK);
    }

}
