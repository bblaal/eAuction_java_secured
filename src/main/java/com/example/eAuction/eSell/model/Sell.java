package com.example.eAuction.eSell.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SELL")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sell {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "PID")
    private String playerID;

    @Column(name = "FID")
    private String franchiseeID;

    @Column(name = "PRICE")
    private Double sellingPrice;
}
