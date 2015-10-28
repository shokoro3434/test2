package com.eitax.recall.front.service;

import java.util.List;

import com.eitax.recall.front.domain.Customer;

public interface CustomerService {
	public List<Customer> findAll();
	public Customer findOne(Integer customerId);
	public void save(Customer customer);

}
