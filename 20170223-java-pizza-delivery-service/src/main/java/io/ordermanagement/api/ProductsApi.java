package io.ordermanagement.api;

import io.ordermanagement.model.Product;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

;

@Api(value = "products", description = "the products API")
public interface ProductsApi {

    @ApiOperation(value = "", notes = "Gets the list of all products. ", response = Product.class, responseContainer = "List", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "An array of `Product` objects", response = Product.class)})
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    ResponseEntity getAllProducts();

    @ApiOperation(value = "", notes = "Creates a new product", response = Product.class, tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Product created successfully", response = Product.class)})
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    ResponseEntity<Product> createProduct(
            @ApiParam(value = "Product to create", required = true) @RequestBody Product product
    );

}
