package com.eitax.recall.front.dao;

import java.util.List;

import com.eitax.recall.front.domain.Customer;

public interface CustomerDAO {
	public abstract List<Customer> findAll();
	public Customer findOne(Integer customerId);
	public abstract void save(Customer customer);
}
