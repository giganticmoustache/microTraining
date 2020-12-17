package com.training.ykb.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.rest.error.ErrorObj;

//@Controller// mvc deki controllerdır, viewa dönmeli
//@ResponseBody//viewa dönmez
@RestController // controller ve responsebodynin birleşmiş halidir.
@RequestMapping("/rest")
public class MyRest {

	@Autowired
	EmployeeManager em;

	@GetMapping("/hello")
	public String helloGet() {
		return "Hello from MyRest GET!";
	}

	@PostMapping("/hello")
	public String helloPost() {
		return "Hello from MyRest POST!";
	}

	@PutMapping("/hello")
	public String helloPut() {
		return "Hello from MyRest PUT!";
	}

	@GetMapping("/hello2/{abc}/{xyz}")
	public String hello2(@PathVariable("abc") String name, @PathVariable("xyz") String surname) {
		return "Hello 2 : " + name + " " + surname;
	}

	@GetMapping("/hello3")
	public String hello3(@RequestParam("is") String name, @RequestParam("soy") String surname) {
		return "Hello 3 : " + name + " " + surname;
	}

	// DO NOT MIX @PathVariable and @RequestParam
	@GetMapping("/hello4/{is}")
	public String hello4(@PathVariable("is") String name, @RequestParam("soy") String surname) {
		return "Hello 4 : " + name + " " + surname;
	}

	@GetMapping("/hello5")
	public String hello5(@RequestHeader("is") String name, @RequestHeader("soy") String surname) {
		return "Hello 5 : " + name + " " + surname;
	}

	@PostMapping("/hello6")
	public String hello6(@RequestBody final Employee emp) {
		return "Hello 6 : " + emp;
	}

	@PostMapping(value = "/hello7", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Employee hello7(@RequestBody final Employee emp) {
		emp.setAge(100);
		return emp;
	}

	@PostMapping("/hello8")
	public String hello8(@Validated @RequestBody final Employee emp, final HttpServletRequest http) {
//		if (emp.getAge() < 0) {
//			throw new IllegalArgumentException("age cannot be less than 0!");
//		}

		boolean result = this.em.addEmployee(emp);
		return "Hello 8 : " + emp + " result : " + result;
	}
}
