package com.javaacademy.onegramchat;

import com.javaacademy.onegramchat.model.Message;
import com.javaacademy.onegramchat.model.User;
import com.javaacademy.onegramchat.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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
        checkAuthorisation(currentUser);
        System.out.printf("%s, до свидания возвращайтесь еще!", currentUser.getName());
        currentUser = null;
    }

    public void writeMessage(Scanner scanner) {
        checkAuthorisation(currentUser);
        System.out.println("Введите получателя!");
        String recipientName = scanner.nextLine();
        User recipient = userService.findUserByName(recipientName)
                .orElseThrow(() -> new RuntimeException("Получателя с таким именем не существует!"));

        System.out.println("Введите сообщение:");
        String text = scanner.nextLine();

        Message outcomeMessage = Message.builder().recipient(recipient).text(text).sender(currentUser).isIncome(false)
                .build();
        Message incomeMessage = outcomeMessage.toBuilder().isIncome(true).build();

        currentUser.addMessage(outcomeMessage);
        recipient.addMessage(incomeMessage);
    }
}