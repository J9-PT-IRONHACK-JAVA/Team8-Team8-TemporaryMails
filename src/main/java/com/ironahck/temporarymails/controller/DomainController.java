package com.ironahck.temporarymails.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("domains")
public class DomainController {

    @GetMapping
    public String getDomain() {

    }
}
