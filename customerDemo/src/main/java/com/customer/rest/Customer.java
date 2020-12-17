package com.customer.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.customer.rest.validation.EndsWith;

public class Customer {

	@Size(min = 2, max = 20, message = "length of name must be between 2 and 20!")
	private String name;
	
	@Size(min = 2, max = 30, message = "length of name must be between 2 and 30!")
	@EndsWith(value = "k")
	private String surname;
	
	@Min(value = 0, message = "age cannot be less than 0!")
	@Max(value = 120, message = "age cannot be greater than 120!")
	private Integer age;

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}
}
