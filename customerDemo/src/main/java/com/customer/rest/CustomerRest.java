package com.customer.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerRest {

	@Autowired
	private CustomerManager cm;
	
	@GetMapping("getCustomers")
	public Collection<Customer> getCustomers() throws Exception {
		return this.cm.getCustomers();
	}
	
	@PostMapping("addCustomer")
	public String addCustomer(@Validated @RequestBody final Customer customer) throws Exception {
		Boolean result = this.cm.addCustomer(customer);
		return "Result: " + result;
	}
	
	@DeleteMapping("deleteCustomer")
	public String deleteCustomer(@Validated @RequestBody final Customer customer) {
		Boolean result = this.cm.deleteCustomer(customer);
		return "Result: " + result;
	}
}
