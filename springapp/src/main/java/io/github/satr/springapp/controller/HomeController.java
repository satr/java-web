package io.github.satr.springapp.controller;

import io.github.satr.springapp.service.OrderService;
import io.github.satr.springapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private final ProductService productService;
    private final OrderService orderService;

    public HomeController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Order> orders = this.orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "home";
    }

    @GetMapping("/create-product")
    public String showCreateProductForm(Model model) {
        model.addAttribute("status", "");
        return "create-product";
    }

    @GetMapping("/create-order")
    public String showCreateOrderForm(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("status", "");
        return "create-order";
    }
}
