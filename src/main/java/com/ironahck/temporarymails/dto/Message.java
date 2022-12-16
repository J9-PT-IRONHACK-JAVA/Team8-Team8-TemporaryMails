package com.ironahck.temporarymails.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Message {

  @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromAddress;
    private String fromName;

    private String messageId;

    private String accountId;

}
