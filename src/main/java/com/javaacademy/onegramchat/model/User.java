package com.javaacademy.onegramchat.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @NonNull
    @EqualsAndHashCode.Include
    String name;
    String password;
    @Builder.Default
    @NonNull
    List<Message> sentMessages = new ArrayList<>();
    @Builder.Default
    @NonNull
    List<Message> receivedMessages = new ArrayList<>();
}
