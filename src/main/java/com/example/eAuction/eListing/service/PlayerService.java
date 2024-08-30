package com.example.eAuction.eListing.service;

import com.example.eAuction.eListing.model.Player;
import com.example.eAuction.eListing.repository.PlayerRepository;
import com.example.eAuction.eSell.model.PlayersForAuction;
import com.example.eAuction.eSell.repository.DB2PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    DB2PlayerRepository db2PlayerRepository;

    @Transactional
    public void addPlayerForListing(Player player){
        playerRepository.save(player);
    }

    @Transactional
    public void addPlayerForAuction(PlayersForAuction player){
        db2PlayerRepository.save(player);
    }

    public Optional<Player> getPlayerById(String playerId){
        return playerRepository.findById(playerId);
    }

    public Iterable<Player> getAllPlayers(){
        return playerRepository.findAll();

    }

}
