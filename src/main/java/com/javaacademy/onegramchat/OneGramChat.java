package com.javaacademy.onegramchat;

import com.javaacademy.onegramchat.chat.Chat;
import com.javaacademy.onegramchat.model.User;
import lombok.Cleanup;
import lombok.experimental.SuperBuilder;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

import static com.javaacademy.onegramchat.util.UserServiceUtil.*;

@SuperBuilder
public class OneGramChat extends Chat {
    private User currentUser;

    @Override
    public void login() {
        @Cleanup
        Scanner scanner = getScanner();
        User referenceUser = createUserFromConsole(scanner);
        checkUserRegistration(referenceUser.getName(), userService);
        Optional<User> currentUser = userService.findUserByName(referenceUser.getName());
        checkUserPassword(currentUser.get(), referenceUser.getPassword());
        this.currentUser = currentUser.get();
        System.out.printf("%s, вы вошли в чат", this.currentUser.getName());
    }

    @Override
    public void registration() {
        @Cleanup
        Scanner scanner = getScanner();
        User newUser = createUserFromConsole(scanner);
        userService.registerUser(newUser);
        System.out.printf("%s, вы успешно зарегестрировались%n", newUser.getName());
    }

    @Override
    public void logout() {
        if (Objects.isNull(currentUser)) {
            throw new RuntimeException("Перед тем как выйти, вы должны авторизоваться");
        }
        System.out.printf("%s, досвидания возвращайтесь еще!", currentUser.getName());
        currentUser = null;
    }

    @Override
    public void sendMessage() {
        @Cleanup
        Scanner scanner = getScanner();
    }

    @Override
    public void readMessage() {
    }

    private Scanner getScanner() {
        return new Scanner(System.in);
    }
}