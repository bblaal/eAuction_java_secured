package com.example.eAuction.eListing.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "FRANCHISEE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Franchisee {

    @Id
    @Column(name = "FRANCHISEE_ID")
    private String franchiseeId;

    @Column(name = "FRANCHISEE_NAME")
    private String franchiseeName;

    @Column(name = "BALANCE")
    private double balance;

    @Column(name = "FRANCHISEE_EMAIL")
    private String franchiseeEmail;

    @Column(name = "FRANCHISEE_CONTACT")
    private String franchiseeContact;


}
