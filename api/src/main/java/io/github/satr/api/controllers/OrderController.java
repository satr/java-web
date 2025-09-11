package io.github.satr.api.controllers;

import io.github.satr.api.model.Order;
import io.github.satr.api.services.OrderService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "Get all orders")
    @ApiResponse(
            responseCode = "200",
            description = "List of orders",
            content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = Order.class))
            )
    )
    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable String id) {
        return orderService.getOrderById(id);
    }


    @PostMapping("/orders")
    public void createOrder(@RequestBody Order order) {
        order = orderService.createOrder(order);
        this.orderService.createOrder(order);
    }
}
