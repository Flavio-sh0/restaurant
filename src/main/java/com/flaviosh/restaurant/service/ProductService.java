package com.flaviosh.restaurant.service;

import com.flaviosh.restaurant.dto.ProductDTO;
import com.flaviosh.restaurant.model.Product;
import com.flaviosh.restaurant.repository.ProductRepository;
import com.flaviosh.restaurant.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ApiResponse<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return new ApiResponse<>(true, products, null);
    }

    public ApiResponse<Product> createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setType(productDTO.getType());
        Product newProduct = productRepository.save(product);
        return new ApiResponse<>(true, newProduct, null);
    }

    public ApiResponse<Optional<Product>> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);

        return new ApiResponse<>(true, product, null);
    }

    public ApiResponse<Product> updateProduct(Long id, ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            if (productDTO.getName() != null) {
                product.setName(productDTO.getName());
            }
            if (productDTO.getPrice() != null) {
                product.setPrice(productDTO.getPrice());
            }
            if (productDTO.getDescription() != null) {
                product.setDescription(productDTO.getDescription());
            }
            if (productDTO.getType() != null) {
                product.setType(productDTO.getType());
            }

            Product updatedProduct = productRepository.save(product);

            return new ApiResponse<>(true, updatedProduct, null);
        } else {
            Map<String, String> map = new HashMap<>();
            map.put("id", "User with id " + id + " not found");
            return new ApiResponse<>(false, null, map);
        }
    }

    public ApiResponse<Product> deleteProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            productRepository.deleteById(id);
            return new ApiResponse<>(true, null, null);
        } else {
            Map<String, String> map = new HashMap<>();
            map.put("id", "User with id " + id + " not found");
            return new ApiResponse<>(false, null, map);
        }
    }
}
