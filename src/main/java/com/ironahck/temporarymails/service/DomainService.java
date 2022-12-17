package com.ironahck.temporarymails.service;

import com.ironahck.temporarymails.controller.DomainController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DomainService {

    private DomainController domainController;

    public String getDomain() {
        return domainController.getDomain();
    }
}
