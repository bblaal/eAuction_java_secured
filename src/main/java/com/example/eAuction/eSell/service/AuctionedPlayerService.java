package com.example.eAuction.eSell.service;

import com.example.eAuction.eListing.model.Player;
import com.example.eAuction.eSell.model.PlayersForAuction;
import com.example.eAuction.eSell.repository.DB2PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuctionedPlayerService {

    @Autowired
    DB2PlayerRepository playerRepository;

    public Optional<PlayersForAuction> getPlayerById(String playerId){
        return playerRepository.findById(playerId);
    }

    public Iterable<PlayersForAuction> getAllPlayers(){
        return playerRepository.findAll();

    }
}
