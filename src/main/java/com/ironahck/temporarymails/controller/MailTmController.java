package com.ironahck.temporarymails.controller;

import com.ironahck.temporarymails.dto.Account;
import com.ironahck.temporarymails.proxy.MailTmProxy;
import feign.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MailTmController {
    @Autowired
    MailTmProxy mailTmProxy;

    private String bearerToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2NzExMzU5MzIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJ1c2VybmFtZSI6Iml2YW5AbmlnaHRvcmIuY29tIiwiaWQiOiI2MzliODI5NmY0NTEyNTkyZjMxMDQ1ZTIiLCJtZXJjdXJlIjp7InN1YnNjcmliZSI6WyIvYWNjb3VudHMvNjM5YjgyOTZmNDUxMjU5MmYzMTA0NWUyIl19fQ.m3MxgONlf1Qir0JpZbZZQkIw1LkkXSrJSzb5guAQgNt0M-jcr-Q6x6XZZKAk1SB7IISQjlb-XYRWaocDauvSpw";


    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{id}")
    public Account getAccountById(@RequestHeader(value = "Authorization", required = true) String authorizationHeader, @PathVariable String id){
        return mailTmProxy.getAccountById(authorizationHeader, id);
    };
/*    @GetMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
   public Account getById(@PathVariable String id, @RequestHeader(value = "Authorization", required = true) String authorizationHeader){
        return mailTmProxy.getAccountById(id);
    }*/


}
