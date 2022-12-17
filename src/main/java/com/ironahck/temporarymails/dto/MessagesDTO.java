package com.ironahck.temporarymails.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MessagesDTO {

    @JsonAlias("hydra:member")
    ArrayList<MessageIntoDTO> member;

}
