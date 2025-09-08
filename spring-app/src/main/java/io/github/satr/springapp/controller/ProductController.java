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

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/create-product")
    public String showCreateProductForm(Model model) {
        model.addAttribute("status", "");
        return "create-product";
    }

    @PostMapping("/create-product")
    public String createProduct(@RequestParam String name,
                                @RequestParam Double price,
                                Model model) {
        var product = productService.createProduct(name, price);
        model.addAttribute("status", "Product created: " + product.getName());
        return "create-product";
    }
}

