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
    @ToString.Exclude
    String password;

    @NonNull
    @ToString.Exclude
    @Builder.Default
    List<Message> sentMessages = new ArrayList<>();

    @NonNull
    @ToString.Exclude
    @Builder.Default
    List<Message> receivedMessages = new ArrayList<>();

    @NonNull
    public List<Message> getSentMessages() {
        return new ArrayList<>(sentMessages);
    }
    @NonNull
    public List<Message> getReceivedMessages() {
        return new ArrayList<>(receivedMessages);
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
