package com.phonepe.walletservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonepe.walletservice.entity.User;
import com.phonepe.walletservice.repository.UserRepository;

@Service
public class WalletService {

    @Autowired
    private UserRepository userRepository;

    public String transferMoney(String senderUsername, String receiverUsername, Double amount) {
        User sender = userRepository.findByUsername(senderUsername).orElseThrow(() -> new RuntimeException("Sender not found!"));
        User receiver = userRepository.findByUsername(receiverUsername).orElseThrow(() -> new RuntimeException("Receiver not found!"));

        if (sender.getWalletBalance() < amount) {
            return "Insufficient balance!";
        }

        sender.setWalletBalance(sender.getWalletBalance() - amount);
        receiver.setWalletBalance(receiver.getWalletBalance() + amount);

        userRepository.save(sender);
        userRepository.save(receiver);

        return "Transaction successful!";
    }
}

