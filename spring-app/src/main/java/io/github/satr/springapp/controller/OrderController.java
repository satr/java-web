package io.github.satr.springapp.controller;

import io.github.satr.springapp.model.OrderItem;
import io.github.satr.springapp.service.OrderService;
import io.github.satr.springapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;

    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping("/create-order")
    public String showCreateOrderForm(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("status", "");
        return "create-order";
    }

    @PostMapping("/create-order")
    public String createOrder(@RequestParam Map<String, String> params, Model model) {
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        var products = productService.getAllProducts();
        for (var product : products) {
            String quantityParam = params.get("quantity_" + product.getId());
            if (quantityParam != null) {
                int quantity = 0;
                try {
                    quantity = Integer.parseInt(quantityParam);
                } catch (NumberFormatException ignored) {}
                if (quantity > 0) {
                    OrderItem item = new OrderItem();
                    item.setProductId(product.getId());
                    item.setQuantity(quantity);
                    item.setPrice(product.getPrice());
                    orderItems.add(item);
                }
            }
        }
        var order = orderService.createOrder(orderItems);
        model.addAttribute("status", "Order created: " + order.getId());
        model.addAttribute("products", products);
        return "create-order";
    }
}
