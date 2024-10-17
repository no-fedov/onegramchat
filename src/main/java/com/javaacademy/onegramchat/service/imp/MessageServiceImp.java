package com.javaacademy.onegramchat.service.imp;

import com.javaacademy.onegramchat.model.User;
import com.javaacademy.onegramchat.model.Message;
import com.javaacademy.onegramchat.model.User;
import com.javaacademy.onegramchat.service.MessageService;

public class MessageServiceImp implements MessageService {

    @Override
    public void readAllMessages(User user) {
        for (int i = 0; i < user.getSentMessages().size(); i++){
            System.out.println("письмо к {" + user.getSentMessages().get(i).getRecipient() + "}: {" + user.getSentMessages().get(i).getText() + "}");
        }
        for (int i = 0; i < user.getReceivedMessages().size(); i++){
            System.out.println("письмо от {" + user.getSentMessages().get(i).getSender() + "}: {" + user.getSentMessages().get(i).getText() + "}");
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
    }
}