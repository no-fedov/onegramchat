package com.javaacademy.onegramchat.util;

import com.javaacademy.onegramchat.model.User;
import com.javaacademy.onegramchat.service.UserService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserServiceUtil {
    public static void checkDuplicateUserName(String name, UserService service) {
        Optional<User> currentUser = service.findUserByName(name);

        if (currentUser.isPresent()) {
            throw new RuntimeException(String.format("Имя %s уже занято. " +
                    "Зарегестрируйтесь под другим именем", name));
        }
    }

    public static void checkUserRegistration(String name, UserService service) {
        Optional<User> currentUser = service.findUserByName(name);

        if (currentUser.isEmpty()) {
            throw new RuntimeException("Вы еще не зарегестрированы");
        }
    }

    public static void checkUserPassword(User user, String password) {
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Неверный пароль, попробуйте снова");
        }
    }
}
