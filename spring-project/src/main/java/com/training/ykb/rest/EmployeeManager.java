package com.training.ykb.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class EmployeeManager {

	private Map<String, Employee> empMap = new ConcurrentHashMap<>();
	
	public boolean addEmployee(final Employee emp) {
		this.empMap.put(emp.getName(), emp);
		return true;
	}
}
