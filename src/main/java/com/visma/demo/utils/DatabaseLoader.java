package com.visma.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.visma.demo.entities.Customer;
import com.visma.demo.entities.Product;
import com.visma.demo.repositories.CustomerRepository;
import com.visma.demo.repositories.ProductRepository;
import com.visma.demo.types.RebateType;

@Component
public class DatabaseLoader implements ApplicationRunner {

	private final ProductRepository productRepository;
	private final CustomerRepository customerRepository;

	@Autowired
	public DatabaseLoader(ProductRepository productRepository, CustomerRepository customerRepository) {
		this.productRepository = productRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.productRepository.save(new Product("Laptop", 1400.00));
		this.productRepository.save(new Product("Office chair", 42.50));
		this.productRepository.save(new Product("Desk", 99.99));
		this.productRepository.save(new Product("White board", 50.00));
		this.customerRepository.save(new Customer("BestOfficeFurnitures Oy", RebateType.LONGTERMCUSTOMER));
		this.customerRepository.save(new Customer("Tradesk Oy", RebateType.LONGTERMCUSTOMER));
		this.customerRepository.save(new Customer("Retailh Oy", RebateType.NEWCUSTOMER));
		this.customerRepository.save(new Customer("Salers Oy", RebateType.NONE));
	}
}