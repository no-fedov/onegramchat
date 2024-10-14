package com.javaacademy.onegramchat.util;

import com.javaacademy.onegramchat.model.User;
import com.javaacademy.onegramchat.service.UserService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserServiceUtil {
    private static final int MIN_LENGTH_NAME = 5;

    public static void checkDuplicateUserName(String name, UserService service) {
        service.findUserByName(name).ifPresentOrElse(user -> {
            throw new RuntimeException(String.format("Имя %s уже занято. " +
                    "Зарегестрируйтесь под другим именем", name));
        }, () -> {
        });
    }

    public static void checkUserRegistration(String name, UserService service) {
        service.findUserByName(name).ifPresentOrElse(user -> {
        }, () -> {
            throw new RuntimeException("Вы еще не зарегестрированы");
        });
    }

    public static void checkUserPassword(User user, String password) {
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Неверный пароль, попробуйте снова");
        }
    }

    public static void checkLengthName(String name) {
        if (name.length() < MIN_LENGTH_NAME) {
            throw new RuntimeException(String.format("Длина имени должны бть больше %s символов",
                    MIN_LENGTH_NAME));
        }
    }
}
