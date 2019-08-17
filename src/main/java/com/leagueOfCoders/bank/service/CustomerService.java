package com.leagueOfCoders.bank.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.leagueOfCoders.bank.models.CustomerDetails;

public interface CustomerService {

	List<CustomerDetails> listAll();

	CustomerDetails saveCustomer(CustomerDetails customer);

	CustomerDetails findById(long id);

	CustomerDetails updateCustomer(long id, CustomerDetails customerDetails);

	ResponseEntity<?> deleteCustomer(long id);
	
	public CustomerDetails findByPanId(String panId);
	
	public CustomerDetails findByEmail(String email);
	
	public CustomerDetails findByPhoneNum(String phoneNum);

}
