package com.leagueOfCoders.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leagueOfCoders.bank.models.CustomerDetails;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Long>{
	public CustomerDetails findByPanId(String panId);
	public CustomerDetails findByEmail(String email);
	public CustomerDetails findByPhoneNum(String phoneNum);
}
