package com.leagueOfCoders.bank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.leagueOfCoders.bank.models.CustomerDetails;
import com.leagueOfCoders.bank.service.CustomerService;


@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customer")
	public List<CustomerDetails> getAllCustomers(){
		return customerService.listAll();
	}
	
	@PostMapping("/customer")
	public CustomerDetails createCustomer(@Valid @RequestBody CustomerDetails customer) {
		return customerService.saveCustomer(customer);
		
	}
	
	@GetMapping("/customer/{id}")
	public CustomerDetails getCustomerById(@PathVariable("id") Long id) {
		return customerService.findById(id);
	}
	
	@PutMapping("/customer/{id}")
	public CustomerDetails updateCustomer(@PathVariable("id") Long id,
			@Valid @RequestBody CustomerDetails customerDetails) {
		return customerService.updateCustomer(id, customerDetails);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
		return customerService.deleteCustomer(id);
	}

}
