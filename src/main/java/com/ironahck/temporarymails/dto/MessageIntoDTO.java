package com.ironahck.temporarymails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageIntoDTO {
  private String id;
  private String accountId;
  private String fromAddress;
  private PersonDTO from;
  private String fromName;
  private String subject;

  private String intro;


 /* @Override
  public String toString() {
    return "\nMessageIntoDTO " +
            " accountId: " + accountId +
            ", fromAddress: " + fromAddress +
            ", fromName: " + fromName +
            "from: " + from.toString() +
            ", subject: " + subject +
            ", intro: " + intro + "\n";
  }*/

  @Override
  public String toString() {
    return "\nId: " + id +
            from.toString() +
            "subject: " + subject + "\n";
  }
}
