package com.javaacademy.onegramchat.chat;

import lombok.Getter;

@Getter
public enum MenuButton {
    LOGIN(1),
    REGISTRATION(2),
    LOGOUT(3),
    WRITE(4),
    READ(5),
    EXIT(6);

    private final int number;

    MenuButton(int number) {
        this.number = number;
    }
}