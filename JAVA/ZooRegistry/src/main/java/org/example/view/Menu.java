package org.example.view;

import org.example.controller.Controller;
import org.example.controller.services.CommandsService;
import org.example.controller.services.ZooIndexService;

public class Menu {

    private final Controller controller;
    private boolean keepWorking = true;
    private final static String GREETING_TEXT =
            "Аттестационная работа.\n" +
                    "Система учёта для питомника животных.\n" +
                    "";

    private final String START_MENU_TEXT =
            "Вывести список всех животных\n" +
                    "Вывести даные на животное\n" +
                    "Завести новое животное\n" +
                    "Обучить животное новым командам\n" +
                    "Увидеть список всех доступных команд\n" +
                    "Выход\n";

    public Menu(Controller controller) {
        this.controller = controller;
    }


    public void mainLoop() {
        Display.printText(GREETING_TEXT);
        while (this.keepWorking) {
            mainMenu();
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
                controller.showAnimalData();
                break;
            case 3:
                controller.addAnimal();
                break;
            case 5:
                Display.printText(CommandsService.getCommandList());
                break;
            case 4:
                controller.teachAnimal();
                break;
            default:
                break;
        }
    }
}
