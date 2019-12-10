package com.AccountReplenishment.AccountReplenishment;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Replenishment, Long> {
    Replenishment getReplenishmentByUserID(String userId);
    Replenishment getReplenishmentByCardNumber(String cardNumber);
}
