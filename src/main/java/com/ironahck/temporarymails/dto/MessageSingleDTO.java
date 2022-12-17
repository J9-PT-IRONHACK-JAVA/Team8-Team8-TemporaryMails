package com.ironahck.temporarymails.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageSingleDTO {

    private String id;
    private String accountId;
    private String fromAddress;
    private PersonDTO from;
    private String fromName;
    private String subject;

    private String text;
}
