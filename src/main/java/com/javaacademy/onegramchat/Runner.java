package com.javaacademy.onegramchat;

import com.javaacademy.onegramchat.chat.ChatMenu;
import com.javaacademy.onegramchat.chat.ConsoleChat;
import com.javaacademy.onegramchat.service.MessageService;
import com.javaacademy.onegramchat.service.UserService;
import com.javaacademy.onegramchat.service.imp.MessageServiceImp;
import com.javaacademy.onegramchat.service.imp.UserServiceImp;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserService userService = new UserServiceImp();
        MessageService messageService = new MessageServiceImp();

        ConsoleChat chat = OneGramChat.builder()
                .scanner(scanner)
                .userService(userService)
                .messageService(messageService)
                .build();

        ChatMenu menu = new ChatMenu(chat, scanner);
        menu.startChat();

        UserService userService = new UserServiceImp();
        OneGramChat oneGramChat = new OneGramChat(userService);

        oneGramChat.signIn();

        System.out.println();
        oneGramChat.login();
    }
}