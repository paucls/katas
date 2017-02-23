package io.ordermanagement.api;

import io.ordermanagement.model.Order;
import io.ordermanagement.repository.OrderRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OrdersApiController implements OrdersApi {

    @Autowired
    private OrderRepository orderRepository;

    public ResponseEntity<Order> postOrder(
            @ApiParam(value = "Task to add to the list", required = true) @RequestBody Order order) {
        Order createdOrder = orderRepository.saveAndFlush(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.OK);
    }

}
