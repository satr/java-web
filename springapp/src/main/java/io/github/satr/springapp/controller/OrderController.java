package io.github.satr.springapp.controller;

import io.github.satr.springapp.dto.OrderItemView;
import io.github.satr.springapp.service.OrderService;
import io.github.satr.springapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;

    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @PostMapping("/create-order")
    public String createOrder(@RequestParam Map<String, String> params, Model model) {
        Order order = new Order();
        var orderItems = getOrderItemsFromRequest(params);
        order.setItems(orderItems);
        order = orderService.createOrder(order);
        model.addAttribute("status", "Order created: " + order.getId());
        var products = this.productService.getAllProducts();
        model.addAttribute("products", products);
        return "create-order";
    }

    private List<OrderItem> getOrderItemsFromRequest(Map<String, String> params) {
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        var products = getProductMap();
        for (var param : params.keySet()) {
            if (!param.startsWith("product_id_")) {
                continue;
            }
            String productId = param.substring("product_id_".length());
            var product = products.get(productId);
            if (product == null) {
                continue;
            }
            String quantityParam = params.get("quantity_" + product.getId());
            if (quantityParam == null) {
                continue;
            }
            int quantity;
            try {
                quantity = Integer.parseInt(quantityParam);
            } catch (NumberFormatException ignored) {
                continue;
            }
            if (quantity > 0) {
                OrderItem item = new OrderItem();
                item.setProductId(productId);
                item.setQuantity(quantity);
                item.setPrice(product.getPrice());
                orderItems.add(item);
            }
        }
        return orderItems;
    }

    private Map<String, Product> getProductMap() {
        Map<String, Product> products = productService.getAllProducts().stream().collect(Collectors.toMap(Product::getId, product -> product));
        return products;
    }

    @GetMapping("/order/{orderId}")
    public String showOrderDetails(@PathVariable String orderId, Model model) {
        Order order = orderService.getAllOrders().stream()
            .filter(o -> o.getId().equals(orderId))
            .findFirst()
            .orElse(null);
        if (order == null) {
            model.addAttribute("status", "Order not found");
            model.addAttribute("orderItems", Collections.emptyList());
            return "order-details";
        }
        Map<String, Product> productMap = getProductMap();
        List<OrderItemView> orderItemViews = new ArrayList<>();
        for (OrderItem item : order.getItems()) {
            Product product = productMap.get(item.getProductId());
            String productName = product != null ? product.getName() : "Unknown";
            orderItemViews.add(new OrderItemView(
                item.getProductId(),
                productName,
                item.getPrice(),
                item.getQuantity()
            ));
        }
        model.addAttribute("orderItems", orderItemViews);
        model.addAttribute("orderId", order.getId());
        model.addAttribute("total", order.getTotal());
        return "order-details";
    }
}
