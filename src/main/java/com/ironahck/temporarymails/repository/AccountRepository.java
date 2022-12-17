package com.ironahck.temporarymails.repository;

import com.ironahck.temporarymails.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByInternalId(Long id);

    List<Account> findAll();

    Optional <Account> findByAddressAndPassword(String address, String password);

}
