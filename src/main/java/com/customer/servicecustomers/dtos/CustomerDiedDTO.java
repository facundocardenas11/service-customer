package com.customer.servicecustomers.dtos;

import java.time.LocalDate;

public class CustomerDiedDTO {
	private String name;
	
	private String last_name;
	
	private int age;
	
	private LocalDate birth_date;
	
	private String end_date;

	public CustomerDiedDTO(String name, String last_name, int age, LocalDate birth_date, String end_date) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.age = age;
		this.birth_date = birth_date;
		this.end_date = end_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setBirthDate(LocalDate birth_date) {
		this.birth_date = birth_date;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public LocalDate getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(LocalDate birth_date) {
		this.birth_date = birth_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
}
