package com.ironahck.temporarymails.service;


import com.ironahck.temporarymails.controller.MailTmController;
import com.ironahck.temporarymails.service.AccountService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Data
@RequiredArgsConstructor
public class MainMenu {

    //    private final MailTmController mailTmController;
    private final AccountService accountService;
    private final Scanner userInput;

//   private String bearerToken = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2NzExMzU5MzIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJ1c2VybmFtZSI6Iml2YW5AbmlnaHRvcmIuY29tIiwiaWQiOiI2MzliODI5NmY0NTEyNTkyZjMxMDQ1ZTIiLCJtZXJjdXJlIjp7InN1YnNjcmliZSI6WyIvYWNjb3VudHMvNjM5YjgyOTZmNDUxMjU5MmYzMTA0NWUyIl19fQ.m3MxgONlf1Qir0JpZbZZQkIw1LkkXSrJSzb5guAQgNt0M-jcr-Q6x6XZZKAk1SB7IISQjlb-XYRWaocDauvSpw";
//   private String bearerToken1;


    // esta funcion nos printa por pantalla el account que le pedimos con su id y su bearer_token
  /*  public void printAccount (){
       // var myAccount = mailTmController.getAccountById("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2NzExMzU5MzIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJ1c2VybmFtZSI6Iml2YW5AbmlnaHRvcmIuY29tIiwiaWQiOiI2MzliODI5NmY0NTEyNTkyZjMxMDQ1ZTIiLCJtZXJjdXJlIjp7InN1YnNjcmliZSI6WyIvYWNjb3VudHMvNjM5YjgyOTZmNDUxMjU5MmYzMTA0NWUyIl19fQ.m3MxgONlf1Qir0JpZbZZQkIw1LkkXSrJSzb5guAQgNt0M-jcr-Q6x6XZZKAk1SB7IISQjlb-XYRWaocDauvSpw ", "639b8296f4512592f31045e2");
        var myAccount = mailTmController.getAccountById(bearerToken, "639b8296f4512592f31045e2");
        System.out.println(myAccount);
    }*/

    public void start() {

        var selection = "start";

        do {
            if (selection.equals("start")) {
                System.out.println("""
                        Welcome to the TemporaryMail application.
                        1) Create an  account.
                        2) Log in.
                        3) Exit
                        """);
            }

            selection = userInput.nextLine();

            if (selection.equals("1")) {
                accountService.createAccount();
            } else if (selection.equals("2")) {

            } else if (selection.equals("3")) {
                System.exit(0);
            } else {
                System.out.println("Wrong selection, repeat please.");
            }
        } while (!selection.equals("3"));


    }
}
