package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.TransactionRequest;
import com.example.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/credit")
    public ResponseEntity<?> credit(@RequestBody TransactionRequest request) {
        transactionService.credit(request.getUserId(), null, request.getAmount());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/debit")
    public ResponseEntity<?> debit(@RequestBody TransactionRequest request) {
        transactionService.debit(request.getUserId(), null, request.getAmount());
        return ResponseEntity.ok().build();
    }
}
