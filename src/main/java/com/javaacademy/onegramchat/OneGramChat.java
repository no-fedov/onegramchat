package com.javaacademy.onegramchat;

import com.javaacademy.onegramchat.model.Message;
import com.javaacademy.onegramchat.chat.ConsoleChat;
import com.javaacademy.onegramchat.model.User;

import lombok.experimental.SuperBuilder;

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
        checkAuthorisation(currentUser);
        System.out.printf("%s, досвидания возвращайтесь еще!\n", currentUser.getName());
        currentUser = null;
    }

    @Override
    public void sendMessage() {
        checkAuthorisation(currentUser);
        System.out.println("Введите получателя!");
        String recipientName = scanner.nextLine();
        User recipient = userService.findUserByName(recipientName)
                .orElseThrow(() -> new RuntimeException("Получателя с таким именем не существует!"));
        System.out.println("Введите сообщение:");
        String text = scanner.nextLine();
        Message message = Message.builder()
                .text(text)
                .isIncome(false)
                .sender(currentUser)
                .recipient(recipient)
                .build();
        messageService.sendMessage(message);
        System.out.printf("%s отправил сообщение пользователю %s", currentUser.getName(), recipient.getName());
    }

    @Override
    public void readMessage() {
    }
}