package com.ironahck.temporarymails.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class AccountDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internalId;
    private String id;
    private String username;
    private String address;
    private String password;

    private String bearerToken;


    public AccountDTO(String address, String password) {

        this.address = address;
        this.password = password;

    }
}




