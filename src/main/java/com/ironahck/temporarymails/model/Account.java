package com.ironahck.temporarymails.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Entity
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internalId;
    private String id;
    private String username;
    private String address;
    private String password;

    @Column(length = 500)
    private String bearerToken;

    public Account(String address, String password) {

        this.address = address;
        this.password = password;

    }

    @Override
    public String toString() {
        return "ID:" + internalId +
                ", username: " + username +
                ", address: " + address;
    }
}
