package com.ironahck.temporarymails.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ScannerConfig {

    @Bean
    Scanner userInput(){
        return new Scanner(System.in);
    }
}
