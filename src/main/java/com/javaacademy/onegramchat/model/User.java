package com.javaacademy.onegramchat.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @NonNull
    @EqualsAndHashCode.Include
    String name;

    @NonNull
    String password;

    @NonNull
    @Builder.Default
    List<Message> sentMessages = new ArrayList<>();

    @NonNull
    @Builder.Default
    List<Message> receivedMessages = new ArrayList<>();

    public List<Message> getSentMessages () {
        List<Message> sentMessagesCopy = new ArrayList<>();
        sentMessagesCopy.addAll(0,sentMessages);
        return sentMessagesCopy;
    }

    public List<Message> getReceivedMessages () {
        List<Message> receivedMessagesCopy = new ArrayList<>();
        receivedMessagesCopy.addAll(0,receivedMessages);
        return receivedMessagesCopy;
    }

    @NonNull
    public void addMessage(Message message) {
        if (message.isIncome()) {
            receivedMessages.add(message);
        } else {
            sentMessages.add(message);
        }
    }
}
