package com.ironahck.temporarymails.service;

import com.ironahck.temporarymails.controller.AccountController;
import com.ironahck.temporarymails.controller.DomainController;
import com.ironahck.temporarymails.dto.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final Scanner userInput;
    private final AccountController accountController;
    private final DomainController domainController;

    public void createAccount() {
        System.out.println("Enter a username:");
        var username = userInput.nextLine();
        System.out.println("Enter a password:");
        var password = userInput.nextLine();
        var address = username.concat(domainController.getDomain());
        var account = new AccountDTO(address, password);
        var newAccount = accountController.createAccount(account);
        account.setId(newAccount.getId());
        System.out.println(newAccount);
        System.out.println(account.getId());
    }


}
