package com.SendingMoney.SendingMoney;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<SendingMoney, Long> {
    List<SendingMoney> getAllByUserId(String userId);
}
