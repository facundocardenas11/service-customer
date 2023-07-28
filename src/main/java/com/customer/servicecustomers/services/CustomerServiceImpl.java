package com.customer.servicecustomers.services;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.customer.servicecustomers.dtos.CustomerDiedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.servicecustomers.dtos.CustomerDTO;
import com.customer.servicecustomers.models.Customer;
import com.customer.servicecustomers.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	/** Create customer. */
	@Override
	public void createCustomer(CustomerDTO customerDto) {
              
		Customer customer = new Customer();
		customer.setName(customerDto.getName());
		customer.setLastName(customerDto.getLastName());
		customer.setAge(customerDto.getAge());
		customer.setBirthDate(customerDto.getBirthDate());

		
		customerRepository.save(customer);
	}

	/** Indicates average of customers.
	 * 
	 * @return the average of customers.
	 */
	@Override
	public String averageAge() {
		int average = 0;
		List<Customer> customers = customerRepository.findAll();
		int acumulatorAge = 0;
		for(Customer c: customers) {
			acumulatorAge = acumulatorAge + c.getAge();
		}
		try {
			if (customers.size() != 0) {
				average = acumulatorAge / customers.size();
			}
		} catch (Exception e){
			e.getMessage();
		}

		return "The age average is: " + average;
	}


	/**
	 * List of customers and end date died.
	 *
	 * @return customers and his died date.
	 */
	@Override
	public List<CustomerDiedDTO> customersAndEndDate() {
		List<CustomerDiedDTO> customerDiedDTOS = new ArrayList<>();
		for (Customer customer: customerRepository.findAll()) {
			CustomerDiedDTO customerDiedDTO = new CustomerDiedDTO(customer.getName(), customer.getLastName(),
					customer.getAge(), customer.getBirthDate(), calculateEndDate(customer.getBirthDate()));

			customerDiedDTOS.add(customerDiedDTO);
		}
		return customerDiedDTOS;
	}

	/** Calculates the died date, the average date died is 80
	 *
	 * @param birthDate for to calculate died of date.
	 *
	 * @return date of died.
	 */
	private String calculateEndDate(LocalDate birthDate) {
		if (birthDate.getYear() > 1950 && birthDate.getYear()< 1980) {
			return birthDate.getYear() + 30 + "-" + birthDate.getMonthValue()
					+ "-" + birthDate.getDayOfMonth();
		} else {
			return birthDate.getYear() + 60 + "-" + birthDate.getMonthValue()
					+ "-" + birthDate.getDayOfMonth();
		}
	}
}
