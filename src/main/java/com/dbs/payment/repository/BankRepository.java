package com.dbs.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.payment.models.BankBIC;

public interface BankRepository extends JpaRepository<BankBIC,String> {
}