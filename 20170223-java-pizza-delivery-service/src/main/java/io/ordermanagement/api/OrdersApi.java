package io.ordermanagement.api;

import io.ordermanagement.model.Order;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "orders", description = "the orders API")
public interface OrdersApi {

    @ApiOperation(value = "", notes = "Creates a new `Order` resource", response = Order.class, tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Order created successfully", response = Order.class)})
    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    ResponseEntity<Order> createOrder(
            @ApiParam(value = "Order to create", required = true) @RequestBody Order order
    );

}
