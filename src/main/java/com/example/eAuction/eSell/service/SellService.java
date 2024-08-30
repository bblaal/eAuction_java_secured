package com.example.eAuction.eSell.service;

import com.example.eAuction.eListing.model.Player;
import com.example.eAuction.eSell.model.Sell;
import com.example.eAuction.eSell.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SellService {

    @Autowired
    SellRepository sellRepository;

    @Transactional
    public void addSell(Sell sell){
        sellRepository.save(sell);
    }
}
