package com.javaacademy.onegramchat;

import com.javaacademy.onegramchat.service.UserService;
import com.javaacademy.onegramchat.service.imp.UserServiceImp;

public class Runner {
    public static void main(String[] args) {
        // TODO: здесь будем запускать чат
        System.out.println("Hello World");

        UserService userService = new UserServiceImp();
        OneGramChat oneGramChat = new OneGramChat(userService);

        oneGramChat.signIn();

        System.out.println();
        oneGramChat.login();
    }
}