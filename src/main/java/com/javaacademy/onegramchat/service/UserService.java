package com.javaacademy.onegramchat.service;

import com.javaacademy.onegramchat.model.User;
import lombok.NonNull;

import java.util.Optional;

public interface UserService {
    @NonNull
    void registerUser(User user);

    @NonNull
    Optional<User> findUserByName(String name);
}
