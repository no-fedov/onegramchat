package com.javaacademy.onegramchat;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@EqualsAndHashCode(exclude = "isIncome")
public class Message {
    String text;
    boolean isIncome;
    User sender;
    User recipient;
}
