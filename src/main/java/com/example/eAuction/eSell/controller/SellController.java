package com.example.eAuction.eSell.controller;

import com.example.eAuction.eListing.model.Player;
import com.example.eAuction.eSell.model.Sell;
import com.example.eAuction.eSell.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auctionedPlayers/api/v1")
public class SellController {

    @Autowired
    SellService sellService;
    @PostMapping("/sell")
    public String sellPlayer(@RequestBody Sell sellList) {

        System.out.println(sellList.getSellingPrice());
        System.out.println(sellList.getPlayerID());
        sellService.addSell(new Sell(

                sellList.getId(),
                sellList.getPlayerID(),
                sellList.getFranchiseeID(),
                sellList.getSellingPrice()
                )
        );
        return "";
    }
}
