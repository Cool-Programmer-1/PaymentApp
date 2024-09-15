package com.phonepe.walletservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phonepe.walletservice.entity.Transaction;
import com.phonepe.walletservice.repository.TransactionRepository;

@RestController
@RequestMapping("/history")
public class TransactionHistoryController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/user")
    public ResponseEntity<List<Transaction>> getUserTransactions(@RequestParam String username) {
        List<Transaction> sentTransactions = transactionRepository.findBySenderUsername(username);
        List<Transaction> receivedTransactions = transactionRepository.findByReceiverUsername(username);
        sentTransactions.addAll(receivedTransactions);
        return ResponseEntity.ok(sentTransactions);
    }
}
