package com.example.eAuction.eSell.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PlayersForAuction")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlayersForAuction {

    @Id
    @Column(name = "PLAYER_ID")
    private String playerId;

    @Column(name = "PLAYER_NAME")
    private String playerName;

    @Column(name = "DOB")
    private String playerDOB;

    @Column(name = "PLAYER_EMAIL")
    private String playerEmail;

    @Column(name = "PLAYER_CONTACT")
    private String playerContact;

    @Column(name = "PLAYER_SPECIALITY")
    private String playerSpeciality;

    @Column(name = "PLAYER_LOCATION")
    private String playerLocation;
}

