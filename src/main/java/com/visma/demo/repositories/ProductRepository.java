package com.visma.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.visma.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
