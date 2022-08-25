package com.dbs.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.payment.models.MessageCode;

public interface MessageCodeRepository extends JpaRepository<MessageCode, String> {
}
