package io.github.satr.springapp.repository;

import io.github.satr.springapp.model.Product;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ProductRepository {
    private final Map<String, Product> products = new HashMap<>();

    public Product save(Product product) {
        String id = UUID.randomUUID().toString();
        product.setId(id);
        products.put(id, product);
        return product;
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }
}

