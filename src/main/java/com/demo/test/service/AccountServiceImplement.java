package com.demo.test.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.test.model.Account;
import com.demo.test.repository.AccountRepository;

@Service
public class AccountServiceImplement implements AccountService {

	@Autowired
	private AccountRepository accRepository;
	@Override
	public List<Account> getAccount() {
		return accRepository.findAll();
	}

	@Override
	public Account createAccount(Account acc) {
		return accRepository.save(acc);
	}

	@Override
	public Account updateAccount(Account acc) {
		return accRepository.save(acc);
	}

	@Override
	public Account login(String name, String password) {
		return accRepository.Login(name, password);
	}

}
