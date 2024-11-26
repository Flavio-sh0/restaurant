package com.flaviosh.restaurant.repository;

import com.flaviosh.restaurant.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
