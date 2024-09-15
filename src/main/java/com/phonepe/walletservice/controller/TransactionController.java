package com.phonepe.walletservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phonepe.walletservice.service.WalletService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/transfer")
    public ResponseEntity<?> transferMoney(@RequestParam String senderUsername, @RequestParam String receiverUsername, @RequestParam Double amount) {
        String result = walletService.transferMoney(senderUsername, receiverUsername, amount);
        return ResponseEntity.ok(result);
    }
}
