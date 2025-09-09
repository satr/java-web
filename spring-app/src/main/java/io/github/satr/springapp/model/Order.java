package io.github.satr.springapp.model;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private String id;
    private List<OrderItem> items;
}
