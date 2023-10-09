package com.demo.test.service;

import java.util.List;

import com.demo.test.model.Account;

public interface AccountService {

	List<Account> getAccount(); 
	
	Account createAccount(Account acc);
			
	Account updateAccount(Account acc);
	
	Account login(String name, String password);
}
