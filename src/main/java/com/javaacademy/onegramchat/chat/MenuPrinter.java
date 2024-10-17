package com.javaacademy.onegramchat.chat;

import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MenuPrinter {
    private static final String FILE_NAME = "/menu.txt";

    @SneakyThrows
    public static void printMenu() {
        @Cleanup
        InputStream inputStream = MenuPrinter.class.getResourceAsStream(FILE_NAME);
        @Cleanup
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        System.out.println();
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
