package com.ironahck.temporarymails.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final Scanner userInput;
    public void createAccount() {
        System.out.println("Enter a username:");
        var username = userInput.nextLine();
        System.out.println("Enter a password:");
        var password = userInput.nextLine();

    }
}
