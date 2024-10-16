package com.javaacademy.onegramchat.chat;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Scanner;

@RequiredArgsConstructor
public class ChatMenu {
    @NonNull
    private Chat chat;

    @NonNull
    private Scanner scanner;

    public void startChat() {
        while (true) {
            try {
                // TODO: сделать печать меню в отдельном классе
                System.out.println("Печатается меню");
                int userAnswer = scanner.nextInt();
                Arrays.stream(MenuButton.values())
                        .filter(button -> userAnswer == button.getNumber())
                        .findFirst()
                        .ifPresentOrElse(this::menuAction,
                                () -> System.out.println("Неверный ввод"));
            } catch (Exception e) {
                System.out.println("Сбои программы");
            }
        }
    }

    private void menuAction(MenuButton button) {
        switch (button) {
            case LOGIN -> chat.login();
            case REGISTRATION -> chat.registration();
            case LOGOUT -> chat.logout();
            case WRITE -> chat.sendMessage();
            case READ -> chat.readMessage();
            case EXIT -> {
                scanner.close();
                chat.exit();
            }
        }
    }
}