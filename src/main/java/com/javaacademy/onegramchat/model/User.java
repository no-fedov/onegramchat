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
}
