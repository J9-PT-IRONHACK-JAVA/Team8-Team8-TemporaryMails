package com.ironahck.temporarymails.proxy;

import com.ironahck.temporarymails.dto.AccountDTO;
import com.ironahck.temporarymails.dto.MessageIntoDTO;
import com.ironahck.temporarymails.dto.MessagesDTO;
import com.ironahck.temporarymails.dto.MyTokenDTO;
import com.ironahck.temporarymails.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "MailTm", url = "https://api.mail.tm/")
public interface MailTmProxy {





        @RequestMapping(method = RequestMethod.GET, value = "/messages")
        MessagesDTO getMessages(@RequestHeader(value = "Authorization", required = true) String authorizationHeader);

        @RequestMapping(method = RequestMethod.GET, value = "/messages/{id}")
        MessageIntoDTO getMessage(@RequestHeader(value = "Authorization", required = true) String authorizationHeader, @PathVariable String id);

     //Create a NEW ACCOUNT
    @PostMapping(value = "/accounts")
    @ResponseStatus (HttpStatus.CREATED)//pone el codigo 201 si es  OK
    AccountDTO createAccount(@RequestBody Account account);

    @PostMapping("/token")
    @ResponseStatus (HttpStatus.CREATED)//pone el codigo 201 si es  OK
    MyTokenDTO getToken (@RequestBody  Account account);

    //GET an account By Id
    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{id}")
    AccountDTO getAccountById(@RequestHeader(value = "Authorization", required = true) String authorizationHeader, @PathVariable String id);




     /*   @GetMapping("/accounts/{id}")
        @Headers("Authorization : Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2NzExMzU5MzIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJ1c2VybmFtZSI6Iml2YW5AbmlnaHRvcmIuY29tIiwiaWQiOiI2MzliODI5NmY0NTEyNTkyZjMxMDQ1ZTIiLCJtZXJjdXJlIjp7InN1YnNjcmliZSI6WyIvYWNjb3VudHMvNjM5YjgyOTZmNDUxMjU5MmYzMTA0NWUyIl19fQ.m3MxgONlf1Qir0JpZbZZQkIw1LkkXSrJSzb5guAQgNt0M-jcr-Q6x6XZZKAk1SB7IISQjlb-XYRWaocDauvSpw")
        Account getAccountById(@PathVariable String id);*/
}


