package com.customer.servicecustomers.services;


import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.servicecustomers.dtos.CustomerDTO;
import com.customer.servicecustomers.models.Customer;
import com.customer.servicecustomers.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	/** Create customer.
	 * 
	 */
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

	@Override
	public List<Customer> customersAndEndDate() {
		return customerRepository.findAll();
	}
}
