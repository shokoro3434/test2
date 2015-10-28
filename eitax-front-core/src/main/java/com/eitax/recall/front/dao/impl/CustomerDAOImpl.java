package com.eitax.recall.front.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eitax.recall.front.dao.CustomerDAO;
import com.eitax.recall.front.domain.Customer;
import com.eitax.recall.front.repository.CustomerRepository;

@Component
public class CustomerDAOImpl implements CustomerDAO{
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}
	public Customer findOne(Integer customerId){
		return customerRepository.findOne(customerId);
	}

	public void save(Customer customer){
		customerRepository.save(customer);
	}
	
}
