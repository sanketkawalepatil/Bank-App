package com.example.account.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.example.account.entity.Account;
import com.example.account.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountService accountService;
    
    

    public void credit(Long userId, BigDecimal amount) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Account> account = accountService.getAccountForUser(userId);
        BigDecimal newBalance = ((Account) account).getBalance().add(amount);
        if (newBalance.compareTo(BigDecimal.TEN) > 0) {
            throw new RuntimeException("Credit amount exceeds account limit");
        }
        ((Account) account).setBalance(newBalance);
        accountService.save(account);
    }

    public void debit(Long userId, BigDecimal amount) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Account> account = accountService.getAccountForUser(userId);
        BigDecimal newBalance = ((Account) account).getBalance().subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Debit amount exceeds account balance");
        }
        ((Account) account).setBalance(newBalance);
        accountService.save(account);
    }
}
