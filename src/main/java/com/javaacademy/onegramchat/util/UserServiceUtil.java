package com.javaacademy.onegramchat.util;

import com.javaacademy.onegramchat.model.Message;
import com.javaacademy.onegramchat.model.User;
import com.javaacademy.onegramchat.service.UserService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Scanner;

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
            throw new RuntimeException(String.format("Длина имени должна быть больше %s символов",
                    MIN_LENGTH_NAME));
        }
    }

    public static User createUserFromConsole(Scanner scanner) {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();
        checkLengthName(name);
        return User.builder()
                .name(name)
                .password(password).build();
    }
    public static void checkAuthorisation(User user) {
        if (Objects.isNull(user)) {
            throw new RuntimeException("Вы не авторизованы!");
        }
    }
}
