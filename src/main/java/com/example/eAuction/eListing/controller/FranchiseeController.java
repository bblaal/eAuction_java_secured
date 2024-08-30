package com.example.eAuction.eListing.controller;

import com.example.eAuction.eListing.model.Franchisee;
import com.example.eAuction.eListing.service.FranchiseeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/franchisee/api/v1")
public class FranchiseeController {

    @Autowired
    FranchiseeService franchiseeService;

    @GetMapping("/getFranchisee/{franchiseeId}")
    public Optional<Franchisee> getFranchiseeById(@PathVariable("franchiseeId") String franchiseeId){
        return franchiseeService.getFranchiseeById(franchiseeId);
    }

    @GetMapping("/getAllFranchisees")
    public Iterable<Franchisee> getAllFranchisees(){
        return franchiseeService.getAllFranchisee();
    }

    @PostMapping("/saveFranchisee")
    public String saveBooking(@RequestBody Franchisee franchisee){

        return franchiseeService.addFranchisee(new Franchisee(

                        franchisee.getFranchiseeId(),
                        franchisee.getFranchiseeName(),
                        franchisee.getBalance(),
                        franchisee.getFranchiseeEmail(),
                        franchisee.getFranchiseeContact()
                )
        );
    }
}
