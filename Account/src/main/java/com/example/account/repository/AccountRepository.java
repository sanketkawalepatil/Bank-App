package com.example.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.account.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	List<Account> findByUsersUserId(Long userId);

	void save(List<Account> account);


}

