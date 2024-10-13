package com.javaacademy.onegramchat.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Message {
    @NonNull
    String text;

    @EqualsAndHashCode.Exclude
    boolean isIncome;

    @NonNull
    @ToString.Exclude
    User sender;

    @NonNull
    @ToString.Exclude
    User recipient;
}
