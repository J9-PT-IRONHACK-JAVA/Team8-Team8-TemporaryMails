package com.ironahck.temporarymails.repository;

import com.ironahck.temporarymails.model.Account;
import com.ironahck.temporarymails.model.Message;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Optional<Message> findByInterId(Long id);

    List<Message> findAll();



  //  Optional <Message> findByAddressAndPassword(String address, String password);
}
