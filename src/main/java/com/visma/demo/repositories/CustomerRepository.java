package com.visma.demo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.visma.demo.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	// @Query(value = "SELECT * FROM Customer WHERE rebate_type != 'NON'",
	// nativeQuery = true)
	// List<Customer> findCustomersWithRebateAgreement();
}