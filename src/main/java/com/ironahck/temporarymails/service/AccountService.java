package com.ironahck.temporarymails.service;

import com.ironahck.temporarymails.dto.Account;
import com.ironahck.temporarymails.dto.Message;
import com.ironahck.temporarymails.dto.Messages;
import com.ironahck.temporarymails.dto.MyToken;
import com.ironahck.temporarymails.proxy.MailTmProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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
