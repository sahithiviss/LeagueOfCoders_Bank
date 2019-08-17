package com.leagueOfCoders.bank.service;

import java.util.List;
import java.util.Optional;

import com.leagueOfCoders.bank.models.Branch;


public interface BranchService {
	Optional<Branch> findByIfsc(long id);
	Branch saveBranch(Branch branch);
	List<Branch> listAll();
	Branch findByBranchName(String branchName);
	Branch findByPincode(String pincode);
}
