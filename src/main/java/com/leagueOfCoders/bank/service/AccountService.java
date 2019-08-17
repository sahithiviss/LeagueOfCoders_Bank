package com.leagueOfCoders.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.leagueOfCoders.bank.models.Account;
import com.leagueOfCoders.bank.models.CustomerDetails;



public interface AccountService {
	List<Account> listAll();

	Account saveAccount(Account account);

	Account findById(long id);

	Account updateAccount(long id, Account accountDetails);

	ResponseEntity<?> deleteAccount(long id);
	
	Optional<List<Account>> findByCustomer(CustomerDetails id);
	
	Account findByAccountType(String accountType);

}
