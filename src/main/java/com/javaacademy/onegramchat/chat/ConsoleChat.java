package com.javaacademy.onegramchat.chat;

import com.javaacademy.onegramchat.service.MessageService;
import com.javaacademy.onegramchat.service.UserService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

@SuperBuilder
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public abstract class ConsoleChat {
    @NonNull
    Scanner scanner;

    @NonNull
    UserService userService;

    @NonNull
    MessageService messageService;

    public abstract void login();

    public abstract void registration();

    public abstract void logout();

    public abstract void sendMessage();

    public abstract void readMessage();

    public final void exit() {
        System.out.println("Выключение чата");
        scanner.close();
        System.exit(0);
    }
}
