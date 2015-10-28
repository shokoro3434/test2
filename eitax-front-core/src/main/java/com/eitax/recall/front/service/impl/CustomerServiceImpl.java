package com.eitax.recall.front.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eitax.recall.front.dao.CustomerDAO;
import com.eitax.recall.front.domain.Customer;
import com.eitax.recall.front.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	public List<Customer> findAll(){
		return customerDAO.findAll();
	}
	public Customer findOne(Integer customerId){
		return customerDAO.findOne(customerId);
	}
	public void save(Customer customer){
		customerDAO.save(customer);
	}
	
}
