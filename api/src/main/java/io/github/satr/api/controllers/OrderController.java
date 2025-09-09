package io.github.satr.api.controllers;

import io.github.satr.api.model.Order;
import io.github.satr.api.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
        private final OrderService orderService;

        public OrderController(OrderService orderService) {
            this.orderService = orderService;
        }

        @PostMapping("/create-order")
        public void createOrder(@RequestBody Order order) {
            order = orderService.createOrder(order);
            this.orderService.createOrder(order);
        }
}
