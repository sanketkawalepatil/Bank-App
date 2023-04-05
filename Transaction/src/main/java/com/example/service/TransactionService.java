package com.example.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionService {
    
    private final RestTemplate restTemplate;
    
    private static final String ACCOUNT_SERVICE_URL = "http://account-service";
    
    public TransactionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public void credit(Long userId, Long accountId, BigDecimal amount) {
        String creditUrl = ACCOUNT_SERVICE_URL + "/accounts/" + accountId + "/credit";
        TransactionRequest request = new TransactionRequest(userId, amount);
        restTemplate.postForLocation(creditUrl, request);
    }
    
    public void debit(Long userId, Long accountId, BigDecimal amount) {
        String debitUrl = ACCOUNT_SERVICE_URL + "/accounts/" + accountId + "/debit";
        TransactionRequest request = new TransactionRequest(userId, amount);
        restTemplate.postForLocation(debitUrl, request);
    }
}
