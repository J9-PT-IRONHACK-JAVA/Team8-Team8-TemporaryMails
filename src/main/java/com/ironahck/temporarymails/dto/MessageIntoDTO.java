package com.ironahck.temporarymails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageIntoDTO {
  private String id;
  private String accountId;
  private PersonDTO from;
  private String subject;

  private String intro;

  @Override
  public String toString() {
    return "\nId: " + id +
            from.toString() +
            "subject: " + subject + "\n";
  }
}
