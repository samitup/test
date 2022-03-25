package com.visma.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.visma.demo.entities.Product;
import com.visma.demo.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}

	public Optional<Product> findProductById(Long id) {
		return productRepository.findById(id);

	}

}
