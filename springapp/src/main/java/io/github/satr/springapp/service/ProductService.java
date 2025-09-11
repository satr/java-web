package io.github.satr.springapp.service;

import io.github.satr.springapp.api.ProductControllerApi;
import org.springframework.stereotype.Service;
import io.github.satr.springapp.model.Product;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductControllerApi productApi;

    public ProductService(ProductControllerApi productApi) {
        this.productApi = productApi;
    }

    public void createProduct(Product product) {
        if (product.getId() == null || product.getId().isEmpty()) {
            product.setId(UUID.randomUUID().toString());
        }
        productApi.createProduct(product);
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productApi.getProducts();
    }
}
