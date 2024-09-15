package com.phonepe.walletservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phonepe.walletservice.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySenderUsername(String senderUsername);
    List<Transaction> findByReceiverUsername(String receiverUsername);
}

