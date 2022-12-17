package com.ironahck.temporarymails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private String address;
    private String name;

    @Override
    public String toString() {
        return
                "\nfromAddress: " + address +
                "\nfromName: " + name + "\n";
    }
}
