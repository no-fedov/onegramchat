package com.javaacademy.onegramchat.service.imp;

import com.javaacademy.onegramchat.model.Message;
import com.javaacademy.onegramchat.model.User;
import com.javaacademy.onegramchat.service.MessageService;

public class MessageServiceImp implements MessageService {
    @Override
    public void sendMessage(Message message) {
        Message reverseMessage = message.toBuilder()
                .isIncome(true)
                .build();
        User sender = message.getSender();
        sender.addMessage(reverseMessage);
        User recipient = message.getRecipient();
        recipient.addMessage(message);
    }
}