package io.github.satr.api.model;

import lombok.Data;

@Data
public class OrderItem {
    private String productId;
    private Integer quantity;
    private Double price;
}
