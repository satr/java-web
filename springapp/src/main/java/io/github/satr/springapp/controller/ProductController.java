package io.github.satr.springapp.controller;

import io.github.satr.springapp.service.ProductService;
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

    @PostMapping("/create-product")
    public String createProduct(@RequestParam String name,
                                @RequestParam Double price,
                                Model model) {
        var product = new Product();
        product.setName(name);
        product.setPrice(price);
        product = productService.createProduct(product);
        model.addAttribute("status", "Product created: " + product.getName());
        return "create-product";
    }
}

