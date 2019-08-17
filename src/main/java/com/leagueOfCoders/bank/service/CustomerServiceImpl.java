package com.leagueOfCoders.bank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.leagueOfCoders.bank.models.CustomerDetails;
import com.leagueOfCoders.bank.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    
    @Override
    @Transactional
    public List<CustomerDetails> listAll(){
    	return customerRepository.findAll();
    }
    
    @Override
    @Transactional
    public CustomerDetails saveCustomer(CustomerDetails customer) {

    	if((customerRepository.findByPanId(customer.getPanId())==null)
    			&& (customerRepository.findByEmail(customer.getEmail())==null)
    					&& (customerRepository.findByPhoneNum(customer.getPhoneNum())==null))
    	{
    	return customerRepository.save(customer);
    	}
    	return null;
    }
    
    @Override
    @Transactional
    public CustomerDetails findById(long id) {
    	return this.customerRepository.findById(id).get();
    }
    
    @Override
    @Transactional
    public CustomerDetails updateCustomer(long id,CustomerDetails customerDetails) {
    	CustomerDetails customer = customerRepository.findById(id).get();
    	    	customer.setPassword(customerDetails.getPassword());
    	customer.setFirstname(customerDetails.getFirstname());
    	customer.setLastname(customerDetails.getLastname());
    	customer.setEmail(customerDetails.getEmail());
    	customer.setPhoneNum(customerDetails.getPhoneNum());
    	customer.setPanId(customerDetails.getPanId());
    	
    	return customerRepository.save(customer);
    	
    }
    
    @Override
    @Transactional
    public ResponseEntity<?> deleteCustomer(long id){
    	CustomerDetails customer = customerRepository.findById(id).get();
    	customerRepository.delete(customer);
    	return ResponseEntity.ok().build();
    }

	@Override
	public CustomerDetails findByPanId(String panId) {
		// TODO Auto-generated method stub
		return customerRepository.findByPanId(panId);
	}

	@Override
	public CustomerDetails findByEmail(String email) {
		// TODO Auto-generated method stub
		return customerRepository.findByEmail(email);
	}

	@Override
	public CustomerDetails findByPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
		return customerRepository.findByPhoneNum(phoneNum);
	}
}
