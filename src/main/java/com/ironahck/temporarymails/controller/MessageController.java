package com.ironahck.temporarymails.controller;

import com.ironahck.temporarymails.dto.MessagesDTO;
import com.ironahck.temporarymails.proxy.MailTmProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    MailTmProxy mailTmProxy;

    @RequestMapping(method = RequestMethod.GET)
    public MessagesDTO getMessages(@RequestHeader(value = "Authorization") String authorizationHeader){
        return mailTmProxy.getMessages(authorizationHeader);
    }

  /*  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public MessageDTO getMessage(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable String id){
        return mailTmProxy.getMessage(authorizationHeader, id);
    }*/
}
