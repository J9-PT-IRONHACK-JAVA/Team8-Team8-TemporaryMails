package com.ironahck.temporarymails.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internal_id;

    private String id;
   // private String username;
    private String address;
   // private String password;

    private String bearer_token;


    public Account(String id, String address) {
        this.id = id;
        this.address = address;
        this.bearer_token = "";
    }
}




