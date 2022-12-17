package com.ironahck.temporarymails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
  private String id;
  private String accountId;
  private PersonDTO from;
  private String subject;

  private String text;

}
