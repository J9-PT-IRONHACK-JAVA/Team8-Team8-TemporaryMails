package com.ironahck.temporarymails.controller;

import com.google.gson.Gson;
import com.ironahck.temporarymails.dto.AccountDTO;
import com.ironahck.temporarymails.dto.Message;
import com.ironahck.temporarymails.dto.Messages;
import com.ironahck.temporarymails.model.Account;
import com.ironahck.temporarymails.proxy.MailTmProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AccountController {
    @Autowired
    MailTmProxy mailTmProxy;

    private String bearerToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2NzExMzU5MzIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJ1c2VybmFtZSI6Iml2YW5AbmlnaHRvcmIuY29tIiwiaWQiOiI2MzliODI5NmY0NTEyNTkyZjMxMDQ1ZTIiLCJtZXJjdXJlIjp7InN1YnNjcmliZSI6WyIvYWNjb3VudHMvNjM5YjgyOTZmNDUxMjU5MmYzMTA0NWUyIl19fQ.m3MxgONlf1Qir0JpZbZZQkIw1LkkXSrJSzb5guAQgNt0M-jcr-Q6x6XZZKAk1SB7IISQjlb-XYRWaocDauvSpw";

   /* @RequestMapping(method = RequestMethod.POST, value = "/token")
    public String getToken(@RequestBody String address, @RequestBody String password){
        return mailTmProxy.getToken(address, password).getToken();
    };*/

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{id}")
    public AccountDTO getAccountById(@RequestHeader(value = "Authorization", required = true) String authorizationHeader, @PathVariable String id){
        return mailTmProxy.getAccountById(authorizationHeader, id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/messages")
    public Messages getMessages(@RequestHeader(value = "Authorization", required = true) String authorizationHeader){
        return mailTmProxy.getMessages(authorizationHeader);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/messages/{id}")
    public Message getMessage(@RequestHeader(value = "Authorization", required = true) String authorizationHeader, @PathVariable String id){
        return mailTmProxy.getMessage(authorizationHeader, id);
    }

  /*  @PostMapping("/token")
    @ResponseStatus (HttpStatus.CREATED)//pone el codigo 201 si es  OK
    public String getToken (@RequestBody String address, String password) {
        var myToken = mailTmProxy.getToken(address, password);
        return myToken.getToken();
    }*/



    @PostMapping("/accounts")
    @ResponseStatus (HttpStatus.CREATED)//pone el codigo 201 si es  OK
    public Account createAccount (@RequestBody AccountDTO account) {
        return mailTmProxy.createAccount(account);
    }

}
