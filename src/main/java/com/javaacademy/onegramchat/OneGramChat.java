package com.javaacademy.onegramchat;

import com.javaacademy.onegramchat.chat.ConsoleChat;
import com.javaacademy.onegramchat.model.User;
import lombok.experimental.SuperBuilder;

import java.util.Objects;
import java.util.Optional;

import static com.javaacademy.onegramchat.util.UserServiceUtil.*;

@SuperBuilder
public class OneGramChat extends ConsoleChat {
    private User currentUser;

    @Override
    public void login() {
        User referenceUser = createUserFromConsole(scanner);
        checkUserRegistration(referenceUser.getName(), userService);
        Optional<User> currentUser = userService.findUserByName(referenceUser.getName());
        checkUserPassword(currentUser.get(), referenceUser.getPassword());
        this.currentUser = currentUser.get();
        System.out.printf("%s, вы вошли в чат\n", this.currentUser.getName());
    }

    @Override
    public void registration() {
        User newUser = createUserFromConsole(scanner);
        userService.registerUser(newUser);
        System.out.printf("%s, вы успешно зарегестрировались\n", newUser.getName());
    }

    @Override
    public void logout() {
        if (Objects.isNull(currentUser)) {
            throw new RuntimeException("Перед тем как выйти, вы должны авторизоваться");
        }
        System.out.printf("%s, досвидания возвращайтесь еще!\n", currentUser.getName());
        currentUser = null;
    }

    @Override
    public void sendMessage() {
    }

    @Override
    public void readMessage() {
    }
}