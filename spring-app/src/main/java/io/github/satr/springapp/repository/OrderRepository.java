package io.github.satr.springapp.repository;

import io.github.satr.springapp.model.Order;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class OrderRepository {
    private final Map<String, Order> orders = new HashMap<>();

    public Order save(Order order) {
        if (order.getId() == null || order.getId().isEmpty()) {
            order.setId(UUID.randomUUID().toString());
        }
        orders.put(order.getId(), order);
        return order;
    }

    public List<Order> findAll() {
        return new ArrayList<>(orders.values());
    }
}

