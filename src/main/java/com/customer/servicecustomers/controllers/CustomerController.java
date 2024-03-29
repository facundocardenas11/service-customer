package com.customer.servicecustomers.controllers;

import java.util.List;

import com.customer.servicecustomers.dtos.CustomerAverageDTO;
import com.customer.servicecustomers.dtos.CustomerDiedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.servicecustomers.dtos.CustomerDTO;
import com.customer.servicecustomers.services.CustomerServiceImpl;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerService;
	 
	@PostMapping("/createCustomer")
	public ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO customerDto){
		customerService.createCustomer(customerDto);
		return ResponseEntity.ok(customerDto);		
	}
	
	@GetMapping("/kpiOfCustomers")
	public ResponseEntity<CustomerAverageDTO> kpiDeClientes() {
		return ResponseEntity.ok(customerService.averageAge());
	}
	
	@GetMapping("/listCustomers")
	public ResponseEntity<List<CustomerDiedDTO>> listCustomersAndDiedDate(){
		return ResponseEntity.ok(customerService.customersAndEndDate());
	}
}
