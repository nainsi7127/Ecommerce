package com.jpa.ecomm_ops.service;

import com.jpa.ecomm_ops.entity.Product;
import com.jpa.ecomm_ops.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get a product by its ID
    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }

    // Create or update a product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Delete a product by its ID
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    // Soft delete a product (e.g., set 'active' to false)
    public void softDeleteProduct(long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        productOptional.ifPresent(product -> {
            product.setActive(false);
            productRepository.save(product);
        });
    }
}
