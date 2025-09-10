package io.github.satr.springapp.service;

import io.github.satr.springapp.api.ProductControllerApi;
import io.github.satr.springapp.model.Product;
import io.github.satr.springapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductControllerApi productApi;

    public ProductService(ProductRepository productRepository, ProductControllerApi productApi) {
        this.productRepository = productRepository;
        this.productApi = productApi;
        this.createProduct(createSomeProduct("p1", 1.2));
        this.createProduct(createSomeProduct("p2", 10.2));
    }

    private static Product createSomeProduct(String name, double price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        return product;
    }

    public Product createProduct(Product product) {
        if (product.getId() == null || product.getId().isEmpty()) {
            product.setId(UUID.randomUUID().toString());
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsFromApi() {
        // Example usage of generated OpenAPI client
        return productApi.getProducts(); // Adjust method name if needed
    }
}
