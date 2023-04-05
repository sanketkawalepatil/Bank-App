package com.example.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.account.entity.Account;
import com.example.account.repository.AccountRepository;

@Service
public class AccountService {
   
   @Autowired
   private RestTemplate restTemplate;
   
   @Autowired
   private AccountRepository accountRepository;
   
   public void credit(String userId, double amount) {
       String url = "http://transaction-service/credit/" + userId + "/" + amount;
       restTemplate.put(url, null);
   }
   
   public void debit(String userId, double amount) {
       String url = "http://transaction-service/debit/" + userId + "/" + amount;
       restTemplate.put(url, null);
   }

   public List<Account> getAccountForUser(Long userId) {
       return accountRepository.findByUsersUserId(userId);
   }
   
   public void save(List<Account> account) {
       accountRepository.save(account);
   }
}
