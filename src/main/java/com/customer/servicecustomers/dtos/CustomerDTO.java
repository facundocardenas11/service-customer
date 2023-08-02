package com.customer.servicecustomers.dtos;

import java.time.LocalDate;

public class CustomerDTO {
	private String name;
	
	private String last_name;
	
	private int age;
	
	private LocalDate birth_date;
	
	public CustomerDTO() {}

	public CustomerDTO(String name, String last_name, int age, LocalDate birth_date) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.age = age;
		this.birth_date = birth_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getBirthDate() {
		return birth_date;
	}

	public void setBirthDate(LocalDate birth_date) {
		this.birth_date = birth_date;
	}
}
