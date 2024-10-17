package com.javaacademy.onegramchat.service;

import com.javaacademy.onegramchat.model.User;

import com.javaacademy.onegramchat.model.Message;

import lombok.NonNull;

public interface MessageService {
    void readAllMessages (User user);
    @NonNull
    void sendMessage(Message message);
}