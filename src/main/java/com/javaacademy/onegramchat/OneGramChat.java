package com.javaacademy.onegramchat;

import com.javaacademy.onegramchat.model.User;
import com.javaacademy.onegramchat.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

@RequiredArgsConstructor
public class OneGramChat {
    private User currentUser;
    private final Scanner scanner = new Scanner(System.in);

    @NonNull
    private final UserService userService;

    public void signIn() {
        User newUser = createUserFromConsole();
        userService.signIn(newUser);
        System.out.printf("%s, вы успешно зарегестрировались%n", newUser.getName());
    }

    public void login() {
        User referenceUser = createUserFromConsole();
        Optional<User> currentUser = userService.findUserByName(referenceUser.getName());

        if (currentUser.isEmpty()) {
            throw new RuntimeException("Вы еще не зарегестрированы");
        }
        if (!currentUser.get().getPassword().equals(referenceUser.getPassword())) {
            throw new RuntimeException("Неверный пароль, попробуйте снова");
        }
        this.currentUser = currentUser.get();
        System.out.printf("%s, вы вошли в чат", this.currentUser.getName());
    }

    public void logout() {
        if (Objects.isNull(currentUser)) {
            throw new RuntimeException("Перед тем как выйти, вы должны авторизоваться");
        }
        System.out.printf("%s, досвидания возвращайтесь еще!", currentUser.getName());
        currentUser = null;
    }

    private User createUserFromConsole() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();
        return User.builder()
                .name(name)
                .password(password).build();
    }
}