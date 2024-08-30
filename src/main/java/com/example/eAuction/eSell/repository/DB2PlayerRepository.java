package com.example.eAuction.eSell.repository;

import com.example.eAuction.eSell.model.PlayersForAuction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DB2PlayerRepository extends JpaRepository<PlayersForAuction, String> {
}
