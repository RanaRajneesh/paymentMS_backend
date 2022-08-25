package com.dbs.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.payment.models.TransactionHistory;

public interface TransactionRepository extends JpaRepository<TransactionHistory, Long> {


}