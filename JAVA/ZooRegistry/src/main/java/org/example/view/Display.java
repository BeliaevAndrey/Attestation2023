package org.example.view;

import org.example.model.Animal;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Display {

    public static void showPrompt(String prompt) {
        System.out.println(prompt);
        System.out.print("_> ");
    }

    public static void showPrompt() {
        System.out.print("\n_> ");
    }


    public static void printText(String string) {
        System.out.println(string);
    }

    public static void simplePrintList(List<String> string) {
        string.forEach(System.out::println);
    }

    public static void printMenu(String[] menuText) {
        System.out.println();
        AtomicInteger count = new AtomicInteger(0);
        Arrays.stream(menuText).forEach(point -> {
            System.out.printf("%4d   %s\n", count.addAndGet(1), point);
        });
        showPrompt();
    }

    public static void printStringList(List<String> incomingList) {
        AtomicInteger count = new AtomicInteger(0);
        incomingList.forEach(point -> System.out.printf("%4d   %s\n",
                count.addAndGet(1), point));

        showPrompt();
    }

    public static void printAnimalList(List<Animal> incomingList) {
        AtomicInteger count = new AtomicInteger(0);
        incomingList.forEach(point -> {
            System.out.printf("%4d   %s\n", count.addAndGet(1), point);
        });

        showPrompt();
    }

}
