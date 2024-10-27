package com.bank.banking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.banking.model.UserAccount;

@Repository
public interface AccountRepository extends JpaRepository<UserAccount, Long> {
	
	@Query(value = "SELECT * FROM User_Account ua WHERE user_id = ?1", nativeQuery = true)
	UserAccount findByUserId(String userId);

}
