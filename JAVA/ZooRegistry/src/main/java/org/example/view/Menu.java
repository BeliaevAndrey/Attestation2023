package org.example.view;

import org.example.controller.Controller;
import org.example.controller.services.ZooIndexService;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private final Controller controller = new Controller();
    private boolean keepWorking = true;
    private final static String GREETING_TEXT =
            "Аттестационная работа.\n" +
                    "Система учёта для питомника животных.\n" +
                    "";

    private final String START_MENU_TEXT =
            "Вывести список всех животных\n" +
                    "Вывести даные на животное\n" +
                    "Завести новое животное\n" +
                    "Увидеть список команд, которое выполняет животное\n" +
                    "Обучить животное новым командам\n" +
                    "Выход\n";


    public static void mainLoop() {
        Menu menu = new Menu();
        Display.printText(GREETING_TEXT);
        while (menu.keepWorking) {
            menu.mainMenu();
        }
        Display.printText("Finishing...\nGood Bye!");
    }


    void mainMenu() {
        String[] menuLine = START_MENU_TEXT.split("\n");
        Display.printMenu(menuLine);
        int point = ReadKey.readInt(menuLine.length);
        if (point == menuLine.length)
            keepWorking = false;
        switch (point) {
            case 1:
                Display.printAnimalList(ZooIndexService.animalsList);
                break;
            case 2:
                break;
            case 3:
                controller.addAnimal();
                break;
            case 4:
                break;
            case 5:
                controller.teachAnimal();
                break;
            default:
                break;
        }
    }


    void parametersMenu() {
        Display.printMenu(START_MENU_TEXT.split("\n"));
    }
}

