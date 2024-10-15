package com.javaacademy.onegramchat;

import com.javaacademy.onegramchat.model.Message;
import com.javaacademy.onegramchat.model.User;
import com.javaacademy.onegramchat.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

import static com.javaacademy.onegramchat.util.UserServiceUtil.*;

@RequiredArgsConstructor
public class OneGramChat {
    private User currentUser;
    private final Scanner scanner = new Scanner(System.in);

    @NonNull
    private final UserService userService;

    public void signIn() {
        User newUser = createUserFromConsole(scanner);
        userService.registerUser(newUser);
        System.out.printf("%s, вы успешно зарегестрировались%n", newUser.getName());
    }

    public void login() {
        User referenceUser = createUserFromConsole(scanner);
        checkUserRegistration(referenceUser.getName(), userService);

        Optional<User> currentUser = userService.findUserByName(referenceUser.getName());
        checkUserPassword(currentUser.get(), referenceUser.getPassword());

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

    public void writeMessage(Scanner scanner) {
        if (Objects.isNull(currentUser)) {
            throw new RuntimeException("Вы не авторизованы!");
        }
        System.out.println("Введите получателя!");
        String recipientName = scanner.nextLine();
        User recipient = userService.findUserByName(recipientName)
                .orElseThrow(() -> new RuntimeException("Получателя с таким именем не существует!"));

        System.out.println("Введите сообщение:");
        String text = scanner.nextLine();

        Message message = Message.builder().recipient(recipient).text(text).sender(currentUser).isIncome(false).build();

        currentUser.getSentMessages().add(message);
        recipient.getReceivedMessages().add(message);
    }
}