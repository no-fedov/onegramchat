package com.javaacademy.onegramchat.chat;

import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MenuPrinter {
    private static final String FILE_PATH = "src/main/resources/menu.txt";

    @SneakyThrows
    public static void printMenu() {
        @Cleanup
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
