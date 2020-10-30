package com.wirecard.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wirecard.payments.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
