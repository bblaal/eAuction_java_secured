package com.example.eAuction.eSell.repository;

import com.example.eAuction.eSell.model.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellRepository extends JpaRepository<Sell, String> {
}
