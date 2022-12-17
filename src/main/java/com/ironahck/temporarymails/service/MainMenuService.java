package com.ironahck.temporarymails.service;

import com.ironahck.temporarymails.model.Account;
import com.ironahck.temporarymails.utils.Colors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Scanner;

@Service
@RequiredArgsConstructor

public class MainMenuService {

    private final Scanner userInput;
    private final AccountService accountService;

    private final MessageService messageService;

    public void createAccount() {
        System.out.println("\nEnter a username:");
        var username = userInput.nextLine();
        System.out.println("\nEnter a password:");
        var password = userInput.nextLine();
        accountService.createAccount(username, password);
    }

    public void showAllAccounts() {
        System.out.println(Colors.PURPLE_BOLD + "\nList of EXISTING accounts\n" + Colors.RESET);
        for (Account account : accountService.getAllAccounts()) {
            System.out.println(account);
        }
    }

    public Account logInAccount() {
        System.out.println("\nEnter your address:");
        var address = userInput.nextLine();
        System.out.println("\nEnter your password:");
        var password = userInput.nextLine();
        var myAccount = accountService.findMyAccount(address, password);
        if (myAccount.isPresent()) {
            accountService.getAccountById(myAccount);
            return myAccount.get();
        }
        return null;
    }

    public void logOut(){
        System.out.println(Colors.GREEN_BOLD + "\nYou are SUCCESSFULLY loggedOut!\n" + Colors.RESET);
    }

    public void showAllMessages(Account account) {
        messageService.printAllMessages(account);

    }

        public void deleteAccount (){
            System.out.println("\nEnter your address:");
            var address = userInput.nextLine();
            System.out.println("\nEnter your password:");
            var password = userInput.nextLine();
            accountService.deleteAccount(address, password);
        }

    public void showOneMessage() {
        System.out.println("Enter a message id:");
        var mailId = userInput.nextLine();
        messageService.printOneMessage(mailId);
    }

    public void deleteMessage(Account account) {
        System.out.println("Enter a message id: ");
        var messageId = Long.parseLong(userInput.nextLine());
        var token = account.getBearerToken();
        messageService.deleteMessage(token, messageId);
    }
}

