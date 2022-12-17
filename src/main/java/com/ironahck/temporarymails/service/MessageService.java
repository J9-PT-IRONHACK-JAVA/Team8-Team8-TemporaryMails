package com.ironahck.temporarymails.service;

import com.ironahck.temporarymails.controller.MessageController;
import com.ironahck.temporarymails.dto.MessageIntoDTO;
import com.ironahck.temporarymails.model.Account;
import com.ironahck.temporarymails.model.Message;
import com.ironahck.temporarymails.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageController messageController;
    private final MessageRepository messageRepository;


    public void printAllMessages(Account account){
        var token = account.getBearerToken();
        var messageList = messageController.getMessages(token);
        for (MessageIntoDTO message : messageList.getMember()) {
            try {
                messageRepository.save(new Message(message.getId(), message.getAccountId(), message.getFrom().getAddress(), message.getFrom().getName(), message.getSubject(), message.getIntro()));
            } catch (Exception e) {
            }
        }
        System.out.println(messageRepository.findAll());
    }

    public void printOneMessage(String mailId) {
        var mailToRead = messageRepository.findById(Long.parseLong(mailId));
        if (mailToRead.isPresent()) {
            System.out.println(mailToRead.get() + "\n" + mailToRead.get().getText());
        }
    }


}
