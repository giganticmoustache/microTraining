package com.customer.rest;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class CustomerManager {

	private Map<String, Customer> customerList = new ConcurrentHashMap<>();
	
	public Boolean addCustomer(Customer customer) throws Exception {
		if (customerList.containsKey(customer.toString())) {
			throw new Exception("Customer already added!");
		}
		customerList.put(customer.toString(), customer);
		return Boolean.TRUE;
	}
	
	public Boolean deleteCustomer(Customer customer) {
		if (customerList.containsKey(customer.toString())) {
			customerList.remove(customer.toString());
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
	
	public Collection<Customer> getCustomers() throws Exception {
		Collection<Customer> customers = this.customerList.values();
		if (customers == null || customers.isEmpty()) {
			throw new Exception("No customer found!");
		}
		return customers;
	}
}
