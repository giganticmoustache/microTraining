package com.training.ykb.rest.design;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.rest.Employee;

@RestController
@RequestMapping("/employee2/provision")
public class EmployeeRestDesign2 {

	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee emp) {
		return "OK";
	}
	
	@GetMapping("/get")
	public Employee getEmployee(@RequestParam("id") long empId) {
		return null;
	}
	
	@PostMapping("/update")
	public String updateEmployee(@RequestBody Employee emp) {
		return "OK";
	}
	
	@GetMapping("getAll")
	public List<Employee> getEmployees() {
		return null;
	}
}
