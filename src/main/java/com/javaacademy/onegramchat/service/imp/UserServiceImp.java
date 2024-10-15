package com.javaacademy.onegramchat.service.imp;

import com.javaacademy.onegramchat.model.User;
import com.javaacademy.onegramchat.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.javaacademy.onegramchat.util.UserServiceUtil.checkDuplicateUserName;

public class UserServiceImp implements UserService {
    private List<User> users = new ArrayList<>();

    @Override
    public void registerUser(User user) {
        checkDuplicateUserName(user.getName(), this);
        users.add(user);
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();
    }
}
