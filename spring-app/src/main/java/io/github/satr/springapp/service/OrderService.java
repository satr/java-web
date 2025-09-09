package io.github.satr.springapp.service;

import io.github.satr.springapp.model.Order;
import io.github.satr.springapp.model.OrderItem;
import io.github.satr.springapp.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(List<OrderItem> orderItems) {
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setItems(orderItems);
        return orderRepository.save(order);
    }
}

