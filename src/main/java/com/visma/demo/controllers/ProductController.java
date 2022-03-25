package com.visma.demo.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visma.demo.entities.Product;
import com.visma.demo.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id) {
		return productService.findProductById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) throws URISyntaxException {
		if (!product.getName().isEmpty() || product.getStandardPrice() != null) {
			Product savedProduct = productService.saveProduct(product);
			return ResponseEntity.created(new URI("/products/" + savedProduct.getId())).body(savedProduct);
		} else {
			return ResponseEntity.badRequest().build();

		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		return ResponseEntity.ok().build();
	}
}