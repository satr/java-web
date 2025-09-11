package io.github.satr.springapp.controller;

import io.github.satr.springapp.service.ProductService;
import io.github.satr.springapp.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        var products = this.productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/products")
    public String createProduct(@RequestParam String name,
                                @RequestParam Double price,
                                Model model) {
        var product = new Product();
        product.setName(name);
        product.setPrice(price);
        productService.createProduct(product);
        model.addAttribute("status", "Product created: " + product.getName());
        return "products";
    }
}

