package com.javaacademy.onegramchat.service.imp;

import com.javaacademy.onegramchat.model.User;
import com.javaacademy.onegramchat.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.javaacademy.onegramchat.util.UserServiceUtil.checkDuplicateUserName;

public class UserServiceImp implements UserService {
    private final Map<String,User> users = new HashMap<>();

    @Override
    public void registerUser(User user) {
        checkDuplicateUserName(user.getName(), this);
        users.put(user.getName(), user);
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return Optional.ofNullable(users.get(name));
    }
}
