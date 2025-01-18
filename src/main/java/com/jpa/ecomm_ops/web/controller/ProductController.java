package com.jpa.ecomm_ops.web.controller;

import com.jpa.ecomm_ops.entity.Product;
import com.jpa.ecomm_ops.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create or update a product
    @PostMapping
    public ResponseEntity<Product> createOrUpdateProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    // Delete a product by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // Soft delete a product (set 'active' to false)
    @PatchMapping("/{id}/soft-delete")
    public ResponseEntity<Void> softDeleteProduct(@PathVariable long id) {
        productService.softDeleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
