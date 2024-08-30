package com.example.eAuction.eListing.service;

import com.example.eAuction.eListing.model.Franchisee;
import com.example.eAuction.eListing.repository.FranchiseeRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FranchiseeService {

    @Resource
    FranchiseeRepository franchiseeRepository;

    public String addFranchisee(Franchisee franchisee){
        String flag = "";
        try {
            franchiseeRepository.save(franchisee);
            flag = "Success";
        }catch (Exception e){
            flag = "Error";
        }finally {
            return flag;
        }

    }

    public Optional<Franchisee> getFranchiseeById(String franchiseeId){

        return franchiseeRepository.findById(franchiseeId);
    }

    public Iterable<Franchisee> getAllFranchisee(){
        return franchiseeRepository.findAll();

    }
}
