package com.javaacademy.onegramchat.service.imp;

import com.javaacademy.onegramchat.model.Message;
import com.javaacademy.onegramchat.model.User;
import com.javaacademy.onegramchat.service.MessageService;

public class MessageServiceImp implements MessageService {

    @Override
    public void readAllMessages(User user) {
        for (Message sentMessage : user.getSentMessages()) {
            System.out.println("От (" + sentMessage.getSender().getName() + "): " + sentMessage.getText());
        }
        for (Message receivedMessage : user.getReceivedMessages()) {
            System.out.println("Кому (" + receivedMessage.getRecipient().getName() + "): " + receivedMessage.getText());
        }
    }

    @Override
    public void sendMessage(Message message) {
        Message reverseMessage = message.toBuilder()
                .isIncome(true)
                .build();
        User sender = message.getSender();
        sender.addMessage(reverseMessage);
        User recipient = message.getRecipient();
        recipient.addMessage(message);
        System.out.println("Сообщение отправлено");
    }
}