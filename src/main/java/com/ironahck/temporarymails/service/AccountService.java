package com.ironahck.temporarymails.service;

import com.ironahck.temporarymails.controller.AccountController;
import com.ironahck.temporarymails.controller.DomainController;
import com.ironahck.temporarymails.model.Account;
import com.ironahck.temporarymails.repository.AccountRepository;
import com.ironahck.temporarymails.utils.Colors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountController accountController;
    private final DomainController domainController;
    private final AccountRepository accountRepository;

    public void createAccount(String username, String password){
        var address = username.concat(domainController.getDomain());
        var account = new Account(address, password);
        var newAccount = accountController.createAccount(account);
        var bearerToken = accountController.getToken(account).getToken();
        bearerToken = "Bearer " + bearerToken;
        account.setUsername(username);
        account.setBearerToken(bearerToken);
        System.out.println(account.getId());
        System.out.println(account.getBearerToken());
        account.setId(newAccount.getId());
        System.out.println(account.getId());
        save(account);
        System.out.println(Colors.GREEN_BOLD + "\nYou ACCOUNT was SUCCESSFULLY created!\n" + Colors.RESET);
        System.out.println(account);
    }

    public void getAccountById(Optional<Account> account){
        var id = account.get().getId();
        var token = account.get().getBearerToken();
        System.out.println(token);
        var myAccount = accountController.getAccountById(token, id);
        System.out.println(Colors.GREEN_BOLD + "\nWelcome " + account.get().getUsername() + " !\n" + Colors.RESET);
        System.out.println("You are logged SUCCESSFULLY as " + myAccount.getAddress() + " !\n");
        System.out.println(account.get().getId());
    }

    public void deleteAccount(String address, String password) {
        var accountToDelete = accountRepository.findByAddressAndPassword(address, password);
        if (accountToDelete.isPresent()){
            accountController.deleteAccount(accountToDelete.get().getBearerToken() ,accountToDelete.get().getId());
            delete(accountToDelete.get());
            System.out.println("Account deleted successfully!");
        } else {
            System.out.println("Any account has been find by this params");
        }
    }

    public Optional<Account> findByInternalId(Long id) {
        return accountRepository.findByInternalId(id);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public void delete(Account account){
        accountRepository.delete(account);
    }

    public Optional <Account> findMyAccount(String address, String password) {
        return accountRepository.findByAddressAndPassword(address, password);
    }

}
