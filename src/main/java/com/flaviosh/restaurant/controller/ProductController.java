package com.flaviosh.restaurant.controller;

import com.flaviosh.restaurant.dto.ProductDTO;
import com.flaviosh.restaurant.model.Product;
import com.flaviosh.restaurant.service.ProductService;
import com.flaviosh.restaurant.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ApiResponse<List<Product>> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ApiResponse<Product> createProduct(@RequestBody @Valid ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @GetMapping("/{id}")
    public ApiResponse<Optional<Product>> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<Product> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductDTO product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Product> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
