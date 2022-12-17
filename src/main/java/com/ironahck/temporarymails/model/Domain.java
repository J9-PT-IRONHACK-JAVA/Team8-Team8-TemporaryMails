package com.ironahck.temporarymails.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Domain {
    private String domain;

    public Domain() {
        this.domain = "@nightorb.com";
    }
}
