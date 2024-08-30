package com.example.eAuction.eListing.controller;

import com.example.eAuction.eListing.model.Player;
import com.example.eAuction.eListing.service.PlayerService;
import com.example.eAuction.eSell.model.PlayersForAuction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/players/api/v1")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/players/{playerId}")
    public Optional<Player> getPlayerById(@PathVariable("playerId") String playerId){
        return playerService.getPlayerById(playerId);
    }

    @GetMapping("/players")
    public Iterable<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @PostMapping("/addPlayers")
    public String savePlayer(@RequestBody Player getAllPlayers){

        playerService.addPlayerForListing(new Player(

                getAllPlayers.getPlayerId(),
                getAllPlayers.getPlayerName(),
                getAllPlayers.getPlayerDOB(),
                getAllPlayers.getPlayerEmail(),
                getAllPlayers.getPlayerContact(),
                getAllPlayers.getPlayerSpeciality(),
                getAllPlayers.getPlayerLocation()
                )
        );
        playerService.addPlayerForAuction(new PlayersForAuction(

                        getAllPlayers.getPlayerId(),
                        getAllPlayers.getPlayerName(),
                        getAllPlayers.getPlayerDOB(),
                        getAllPlayers.getPlayerEmail(),
                        getAllPlayers.getPlayerContact(),
                        getAllPlayers.getPlayerSpeciality(),
                        getAllPlayers.getPlayerLocation()
                )
        );

        return "";
    }
}
