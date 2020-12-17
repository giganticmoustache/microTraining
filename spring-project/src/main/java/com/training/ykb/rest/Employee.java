package com.training.ykb.rest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.ykb.rest.validation.StartWith;

@XmlRootElement
public class Employee {
	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}

	@NotEmpty
	@Size(min = 2, max = 20, message = "length of name must be between 2 and 20!")
	private String name;
	
	@StartWith(value = "k")
	private String surname;
	
	@Min(value = 0, message = "age cannot be less than 0!")
	private int age;

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
