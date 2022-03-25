package com.visma.demo.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.visma.demo.entities.Customer;
import com.visma.demo.entities.Product;
import com.visma.demo.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<Customer> getAllCustomers() { // Pagination
		return customerService.getCustomers();
	}

	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws URISyntaxException {
		if (!customer.getName().isEmpty() || !customer.getRebateType().toString().isEmpty()) {
			Customer savedCustomer = customerService.saveCustomer(customer);
			return ResponseEntity.created(new URI("/customers/" + savedCustomer.getId())).body(savedCustomer);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return customerService.findCustomerById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomerById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("{id}/discounts")
	public List<Product> getProductsWithRebatesPrices(@PathVariable Long id) {
		return customerService.getRebatePrices(id);
	}

	/*
	 * @GetMapping("/discounts") public List<Customer>
	 * getCustomersWithRebateAgreement() { return
	 * customerService.getCustomersWithRebatePlan(); }
	 */

}
