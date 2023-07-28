package com.customer.servicecustomers.services;

import java.util.List;

import com.customer.servicecustomers.dtos.CustomerDTO;
import com.customer.servicecustomers.dtos.CustomerDiedDTO;
import com.customer.servicecustomers.models.Customer;

public interface CustomerService {
	
	void createCustomer(CustomerDTO customerDto);
	
	String averageAge();
	
	List<CustomerDiedDTO> customersAndEndDate();

}
