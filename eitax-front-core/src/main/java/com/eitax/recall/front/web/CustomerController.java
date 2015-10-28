package com.eitax.recall.front.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eitax.recall.front.domain.Customer;
import com.eitax.recall.front.service.CustomerService;

@Controller
@RequestMapping("customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@ModelAttribute
	private CustomerForm initForm(){
		return new CustomerForm();
	}
	
	@RequestMapping(value="edit",params="form",method=RequestMethod.GET)
	private String edit(@RequestParam Integer customerId,CustomerForm form){
		Customer customer = customerService.findOne(customerId);
		BeanUtils.copyProperties(customer,form);
		System.out.println(form);
		return "customers/edit";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	private String list(Model model){
		Customer c = new Customer();
		c.setFirstName("a");
		c.setLastName("b");
		customerService.save(c);
		List<Customer> customers = customerService.findAll();
		System.out.println(customers);
		model.addAttribute("customers",customers);
		return "customers/list";
	}
}
