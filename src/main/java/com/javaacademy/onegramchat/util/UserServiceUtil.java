package com.javaacademy.onegramchat.util;

import com.javaacademy.onegramchat.model.User;
import com.javaacademy.onegramchat.service.UserService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserServiceUtil {
    public static void checkDuplicateUserName(String name, UserService service) {
        Optional<User> user = service.findUserByName(name);

        if (user.isPresent()) {
            throw new RuntimeException(String.format("Имя %s уже занято. " +
                    "Зарегестрируйтесь под другим именем", name));
        }
    }
}
