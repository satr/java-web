package io.github.satr.springapp.model;

public class OrderItemView {
    private String productId;
    private String productName;
    private Double price;
    private Integer quantity;

    public OrderItemView(String productId, String productName, Double price, Integer quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public Double getPrice() { return price; }
    public Integer getQuantity() { return quantity; }
}

