package com.ironahck.temporarymails.service;

import com.ironahck.temporarymails.controller.MessageController;
import com.ironahck.temporarymails.dto.MessageIntoDTO;
import com.ironahck.temporarymails.dto.MessagesDTO;
import com.ironahck.temporarymails.model.Account;
import com.ironahck.temporarymails.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageController messageController;


    public MessagesDTO getMessages(Account account){
        var token = account.getBearerToken();
       // return
        var messageList = messageController.getMessages(token);
      /*  for(MessageIntoDTO messages : messageList.getMember()){

        }*/
        return messageList;
    }


}
