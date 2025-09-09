package io.github.satr.api.controllers;

import io.github.satr.api.model.Product;
import io.github.satr.api.services.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create-product")
    public void createProduct(@RequestBody Product product){
        productService.createProduct(product);
    }
}

