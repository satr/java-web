package io.github.satr.springapp.service;

import io.github.satr.springapp.api.OrderControllerApi;
import io.github.satr.springapp.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderControllerApi orderApi;

    public OrderService(OrderControllerApi orderApi) {
        this.orderApi = orderApi;
    }

    public void createOrder(Order order) {
        if (order.getId() == null || order.getId().isEmpty()) {
            order.setId(UUID.randomUUID().toString());
        }
        double total = order.getItems().stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
        order.setTotal(total);
        this.orderApi.createOrder(order);
    }

    public List<Order> getAllOrders() {
        return this.orderApi.getOrders();
    }
}

