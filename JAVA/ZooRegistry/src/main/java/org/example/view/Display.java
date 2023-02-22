package org.example.view;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Display {

    public static void showPrompt(String prompt) {
        System.out.println(prompt);
        System.out.print("_> ");
    }

    public static void showPrompt() {
        System.out.print("_> ");
    }


    public static void printText(String string) {
        System.out.println(string);
    }

    public static void simplePrintList(List<String> string) {
        string.forEach(System.out::println);
    }

    public static void printMenu(String[] menuText) {
        AtomicInteger count = new AtomicInteger(0);
        Arrays.stream(menuText).forEach(point -> {
            System.out.printf("%4d   %s\n", count.addAndGet(1), point);
        });
    }

    public static void printList(List<Object> incomingList) {
        AtomicInteger count = new AtomicInteger(0);
        incomingList.forEach(point -> {
            System.out.printf("%4d   %s\n", count.addAndGet(1), point);
        });
    }

}
