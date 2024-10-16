package com.javaacademy.onegramchat.service;

import com.javaacademy.onegramchat.model.Message;

import lombok.NonNull;

public interface MessageService {
    @NonNull
    void sendMessage(Message message);
}