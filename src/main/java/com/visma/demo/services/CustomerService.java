package com.visma.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visma.demo.entities.Customer;
import com.visma.demo.entities.Product;
import com.visma.demo.repositories.CustomerRepository;
import com.visma.demo.types.RebateType;
import com.visma.demo.utils.CalcManager;
import com.visma.demo.utils.RebateCalc;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CalcManager calcManager;

	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	/*
	 * public List<Customer> getCustomersWithRebatePlan() { return
	 * customerRepository.findCustomersWithRebateAgreement(); }
	 */
	public List<Product> getRebatePrices(Long id) {
		Customer customer = customerRepository.getById(id);
		RebateType rebateType = customer.getRebateType();
		return calcManager.countRebate(rebateType);
	}

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);

	}

	public void deleteCustomerById(Long id) {
		customerRepository.deleteById(id);
	}

	public Optional<Customer> findCustomerById(Long id) {
		return customerRepository.findById(id);

	}

}
