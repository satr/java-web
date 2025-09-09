package io.github.satr.springapp.model;

import lombok.Data;

@Data
public class OrderItem {
    private String productId;
    private Integer quantity;
    private Double price;
}
