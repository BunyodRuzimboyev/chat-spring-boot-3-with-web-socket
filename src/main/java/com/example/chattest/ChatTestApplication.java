package com.example.chattest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.chattest", "com.example.chattest.config"})
public class ChatTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatTestApplication.class, args);
    }

}
