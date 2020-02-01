package com.Payment.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayRepository extends JpaRepository<Payment, Long> {
    List<Payment> getAllByUserId(String userId);
}
