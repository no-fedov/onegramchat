package com.javaacademy.onegramchat;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class User {
    @EqualsAndHashCode.Include
    String name;
    @EqualsAndHashCode.Include
    String password;
    List<Message> sentMessages;
    List<Message> receivedMessages;

}
