package com.javaacademy.onegramchat.chat;

import com.javaacademy.onegramchat.service.MessageService;
import com.javaacademy.onegramchat.service.UserService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

@SuperBuilder
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public abstract class Chat {
    @Getter
    @NonFinal
    boolean isDisable;

    @NonNull
    UserService userService;

    @NonNull
    MessageService messageService;

    @NonNull
    Scanner scanner;

    public abstract void login();

    public abstract void registration();

    public abstract void logout();

    public abstract void sendMessage();

    public abstract void readMessage();

    public final void exit() {
        isDisable = true;
        scanner.close();
    }
}
