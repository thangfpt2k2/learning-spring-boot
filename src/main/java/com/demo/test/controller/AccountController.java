package com.demo.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.test.model.Account;
import com.demo.test.service.AccountService;


@RestController
public class AccountController {
	@Autowired
	private AccountService accService;
	
	@GetMapping("/accounts")
	public List<Account> getAccount() {
		return accService.getAccount();
	}
	
	@PostMapping("/account")
	public Account createAccount(@RequestBody Account acc) {
		return accService.createAccount(acc);		
	}
	
	@PutMapping("/account/{id}")
	public Account updateEmployee(@PathVariable Long id, @RequestBody Account acc) {
		return accService.updateAccount(acc);
	}
	@GetMapping("/login")
	public Account Login(@RequestParam String name,@RequestParam String pass) {
			return accService.login(name, pass);
		
	}
}
