package io.github.satr.api.controllers;

import io.github.satr.api.model.Product;
import io.github.satr.api.services.ProductService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Get all products")
    @ApiResponse(
            responseCode = "200",
            description = "List of products",
            content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = Product.class))
            )
    )
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public void createProduct(@RequestBody Product product){
        productService.createProduct(product);
    }
}

