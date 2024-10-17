package com.javaacademy.onegramchat.service.imp;

import com.javaacademy.onegramchat.model.User;
import com.javaacademy.onegramchat.model.Message;
import com.javaacademy.onegramchat.model.User;
import com.javaacademy.onegramchat.service.MessageService;

import java.util.List;
import java.util.function.Function;

public class MessageServiceImp implements MessageService {
    String sentPattern = "письмо к { %s } : { %s }";
    String receivePattern = "письмо от { %s } : { %s }";

    @Override
    public void readAllMessages(User user) {
        printMessage(user.getSentMessages(), sentPattern);
        printMessage(user.getReceivedMessages(), receivePattern);
    }

    private void printMessage (List<Message> messagesList, String pattern) {
        if (messagesList.isEmpty()) {
            return;
        }
        boolean isIncome = messagesList.get(0).isIncome();
        Function<Message, User> func = isIncome
                ? Message::getSender
                : Message::getRecipient;

        for (Message message: messagesList){
            System.out.printf(pattern, func.apply(message).getName(), message.getText());
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