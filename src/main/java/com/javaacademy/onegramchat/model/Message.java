package com.javaacademy.onegramchat.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Data
public class Message {
    @NonNull
    String text;
    @EqualsAndHashCode.Exclude
    boolean isIncome;
    @ToString.Exclude
    User sender;
    @ToString.Exclude
    User recipient;
}
