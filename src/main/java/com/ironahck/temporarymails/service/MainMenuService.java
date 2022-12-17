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

    public void showAllAccounts(){
        System.out.println(Colors.PURPLE_BOLD + "\nList of EXISTING accounts\n" + Colors.RESET);
        for (Account account : accountService.getAllAccounts()){
            System.out.println(account);
        }
    }

    public Account logInAccount(){
        System.out.println("\nEnter your address:");
        var address = userInput.nextLine();
        System.out.println("\nEnter your password:");
        var password = userInput.nextLine();
        var myAccount = accountService.findMyAccount(address, password);
        if (myAccount.isPresent()){
            accountService.getAccountById(myAccount);
            return myAccount.get();
        }
        return null;
    }


    public void showAllMessages(Account account) {
        var messages = messageService.getMessages(account);
        if (messages != null){
            for(MessageIntoDTO message : messages.getMember()){
                System.out.println(message);
            }
        }else{
            System.out.println("This MailBox is Empty");
        }

    public void deleteAccount() {
        System.out.println("\nEnter your address:");
        var address = userInput.nextLine();
        System.out.println("\nEnter your password:");
        var password = userInput.nextLine();
        accountService.deleteAccount(address, password);
    }
}
