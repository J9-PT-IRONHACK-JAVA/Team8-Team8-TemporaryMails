package com.ironahck.temporarymails.model;

import com.ironahck.temporarymails.dto.MessageIntoDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interId;
    @Column(unique = true)
    private Long internalId;
    private String id;
    private String accountId;
    private String fromAddress;
    private String fromName;
    private String subject;
    private String text;

    public Message(String id, String accountId, String fromAddress, String fromName, String subject, String text) {
        this.id = id;
        this.accountId = accountId;
        this.fromAddress = fromAddress;
        this.fromName = fromName;
        this.subject = subject;
        this.text = text;
    }

    @Override
    public String toString() {
        return "\nMessage id: " + interId +
                "\nfromAddress: " + fromAddress +
                "\nfromName: " + fromName +
                "\nsubject: " + subject + "\n";
    }
}
