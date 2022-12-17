package com.ironahck.temporarymails.controller;

import com.ironahck.temporarymails.dto.AccountDTO;
import com.ironahck.temporarymails.dto.MessageIntoDTO;
import com.ironahck.temporarymails.dto.MessageSingleDTO;
import com.ironahck.temporarymails.dto.MyTokenDTO;
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

    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{id}")
    public void deleteAccount(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable String id) {
        mailTmProxy.deleteAccount(authorizationHeader, id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{id}")
    public AccountDTO getAccountById(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable String id){
        return mailTmProxy.getAccountById(authorizationHeader, id);
    };


    //Create ACCOUNT with: id, and address
    @PostMapping("/accounts")
    @ResponseStatus (HttpStatus.CREATED)//pone el codigo 201 si es  OK
    public AccountDTO createAccount (@RequestBody Account account) {
        return mailTmProxy.createAccount(account);
    }

    //Setea el BearerToken de la cuenta que se ha creado
    @PostMapping("/token")
    @ResponseStatus (HttpStatus.CREATED)//pone el codigo 201 si es  OK
    public MyTokenDTO getToken (@RequestBody Account account) {
        return mailTmProxy.getToken(account);

    }

}
