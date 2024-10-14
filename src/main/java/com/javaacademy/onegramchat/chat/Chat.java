package com.javaacademy.onegramchat.chat;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public abstract class Chat {
    @Getter
    private boolean isDisable;

    @NonNull
    private final Scanner scanner;

    public abstract void login();

    public abstract void registration();

    public abstract void logout();

    public abstract void sendMessage();

    public abstract void readMessage();

    public final void exit() {
        isDisable = true;
    }
}
