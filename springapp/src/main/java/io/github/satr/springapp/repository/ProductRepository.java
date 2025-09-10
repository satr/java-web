package io.github.satr.springapp.repository;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ProductRepository {
    private final Map<String, Product> products = new HashMap<>();

    public Product save(Product product) {
        products.put(product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }
}

