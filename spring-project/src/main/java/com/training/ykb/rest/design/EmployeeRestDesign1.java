package com.training.ykb.rest.design;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.rest.Employee;

@RestController
@RequestMapping("/api/v1/employee1/provision")
public class EmployeeRestDesign1 {

	@PutMapping
	public String addEmployee(@RequestBody Employee emp) {
		return "OK";
	}
	
	@GetMapping
	public Employee getEmployee(@RequestParam("id") long empId) {
		return null;
	}
	
	@PatchMapping
	public String updateEmployee(@RequestBody Employee emp) {
		return "OK";
	}
}
