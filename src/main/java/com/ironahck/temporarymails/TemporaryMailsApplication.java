package com.ironahck.temporarymails;

import com.ironahck.temporarymails.controller.MailTmController;
import com.ironahck.temporarymails.menu.MainMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
public class TemporaryMailsApplication implements CommandLineRunner {

    private final MainMenu mainMenu;

    public static void main(String[] args) {
        SpringApplication.run(TemporaryMailsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mainMenu.printAccount();

    }


}

//VOID EXIT
//SYSTEM.EXIT();