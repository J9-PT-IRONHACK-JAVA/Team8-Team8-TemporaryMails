package com.ironahck.temporarymails.Menu;
import com.ironahck.temporarymails.model.Account;
import com.ironahck.temporarymails.service.AccountService;
import com.ironahck.temporarymails.service.MainMenuService;
import com.ironahck.temporarymails.utils.Colors;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Data
@RequiredArgsConstructor
public class MainMenu {
    private final AccountService accountService;
    private final MainMenuService mainMenuService;
    private final Scanner userInput;

    public void start() {

        var selection = "start";
        System.out.println(Colors.PURPLE_BOLD + "\n\nWELCOME TO THE TEMPORARYMAIL APPLICATION" + Colors.RESET);

        do {
            if (selection.equals("start")) {
                String text = """
                        
                        1) Create an account
                        2) See all existing accounts
                        3) Log in
                        4) Delete account \n"""
                        + Colors.RED + "5) Exit\n" + Colors.RESET;
                printDilay(text, 200);
            }

            selection = userInput.nextLine();

            if (selection.equals("1")) {
                mainMenuService.createAccount();
                pressToContinue();
                selection = "start";
            } else if (selection.equals("2")) {
                mainMenuService.showAllAccounts();
                pressToContinue();
                selection = "start";
            } else if (selection.equals("3")) {
                var account = mainMenuService.logInAccount();
                if(account != null){
                    loggedUser(account);
                    System.out.println(Colors.GREEN_BOLD + "\nYou are SUCCESSFULLY logged out!\n" + Colors.RESET);
                }else{
                    System.out.println(Colors.RED_BOLD + "\nIncorrect ACCOUNT\n" + Colors.RESET);
                }
                pressToContinue();
                selection = "start";
            } else if (selection.equals("4")) {
                mainMenuService.deleteAccount();
                pressToContinue();
                selection = "start";
            } else if (selection.equals("5")) {
                System.exit(0);
            } else {
                System.out.println("Wrong selection, repeat please.");
            }
        } while (!selection.equals("5"));
    }

    public void loggedUser(Account account){
        var selection = "start";
        System.out.println(Colors.PURPLE_BOLD + "\nWhat do You want to do now?\n" + Colors.RESET);
        do {
            if (selection.equals("start")) {
                String text = """
                        
                        1) Show all emails
                        2) Show email by id
                        3) Delete email by id
                        4) Log out \n"""
                        + Colors.RED + "5) Exit\n" + Colors.RESET;
                printDilay(text, 200);
            }

            selection = userInput.nextLine();

            if (selection.equals("1")) {
                mainMenuService.showAllMessages(account);
                pressToContinue();
                selection = "start";
            } else if (selection.equals("2")) {
                mainMenuService.showOneMessage();
                pressToContinue();
                selection = "start";
            } else if (selection.equals("3")) {
                mainMenuService.deleteMessage(account);
                pressToContinue();
                selection = "start";
            } else if (selection.equals("4")) {
                mainMenuService.logOut();
            }else if (selection.equals("5")) {
                System.exit(0);
            } else {
                System.out.println("Wrong selection, repeat please.");
            }
        } while (!selection.equals("5"));
    }

    public void pressToContinue(){
        var selection = "start";
        sleep(300);
        do{
            System.out.println(Colors.YELLOW_BOLD + "\n\t[Press ENTER to continue]\n" + Colors.RESET);
            selection = userInput.nextLine();
        }while (!selection.equals(""));
    }

    public static void printDilay(String text, int s) {
        for (String line: text.split("\\n")) {
            MainMenu.sleep(s);
            System.out.println(line);
        }
    }

    public static void sleep(int s){
        try {
            Thread.sleep(s);
        } catch (InterruptedException ignored) {}
    }

}
