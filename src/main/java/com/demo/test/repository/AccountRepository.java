package com.demo.test.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.demo.test.model.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
		@Query("SELECT account FROM Account account WHERE account.username = ?1 AND account.pass = ?2")
		Account Login(String username, String pass);

		@Query("SELECT account FROM Account account WHERE account.username = ?1")
		Optional<Account> findByUsername(String username);
}
