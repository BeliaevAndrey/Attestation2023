package org.example.view;

public class Menu {

    private final String GREETING_TEXT =
            "Аттестационная работа.\n" +
            "Система учёта для питомника животных.\n" +
            "";

    private final String START_MENU_TEXT =
            "Завести новое животное\n" +
            "Увидеть список команд, которое выполняет животное\n" +
            "Обучить животное новым командам\n";

    void greetings() {
        Display.printText(GREETING_TEXT);
    }

    void mainMenu() {
        Display.printMenu(START_MENU_TEXT.split("\n"));
        Display.showPrompt();
    }

    void parametersMenu() {
        Display.printMenu(START_MENU_TEXT.split("\n"));
        Display.showPrompt();
    }


    public static void main(String[] args) {    // TODO: Remove this crutch
        Menu test = new Menu();
        test.greetings();
        test.mainMenu();
        int point = ReadKey.readInt();
        System.out.println(test.START_MENU_TEXT.split("\n")[point - 1]);

    }
}

