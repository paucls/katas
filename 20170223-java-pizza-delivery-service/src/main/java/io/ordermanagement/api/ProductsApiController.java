package io.ordermanagement.api;

import io.ordermanagement.model.Product;
import io.ordermanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ProductsApiController implements ProductsApi {

    ProductRepository productRepository;

    @Autowired
    public ProductsApiController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productRepository.saveAndFlush(product);
        return new ResponseEntity<Product>(createdProduct, HttpStatus.CREATED);
    }

}
