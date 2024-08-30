package com.example.eAuction.eSell.controller;

import com.example.eAuction.eSell.model.PlayersForAuction;
import com.example.eAuction.eSell.service.AuctionedPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auctionedPlayers/api/v1")
public class AuctionedPlayersController {

    @Autowired
    AuctionedPlayerService playerService;

    @GetMapping("/players/{playerId}")
    public Optional<PlayersForAuction> getPlayerById(@PathVariable("playerId") String playerId){
        return playerService.getPlayerById(playerId);
    }

    @GetMapping("/players")
    public Iterable<PlayersForAuction> getAllPlayers(){
        return playerService.getAllPlayers();
    }
}

