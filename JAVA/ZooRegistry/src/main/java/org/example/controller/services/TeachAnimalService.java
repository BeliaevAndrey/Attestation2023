package org.example.controller.services;

import org.example.model.Animal;
import org.example.view.Display;
import org.example.view.ReadKey;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeachAnimalService {

    private final String TEACH_MENU_TEXT =
            "Выбрать животное для обучения\n" +
                    "Увидеть список доступных команд\n" +
                    "Выход\n";

    public void startTeaching(String subType) {
        List<Animal> animals = ZooIndexService.animalsList.stream().filter(
                animal -> animal.getClass().getSimpleName().equals(subType)).
                collect(Collectors.toList());
        System.out.println(animals);
    }

    void teachMenu() {
        String[] menuLine = TEACH_MENU_TEXT.split("\n");
        List<String> subTypes = ZooIndexService.getAnimalSubTypesAsList();
        Display.printMenu(menuLine);
        Display.showPrompt();
        int point = ReadKey.readInt();
        if (point == menuLine.length)
            return;
        switch (point) {
            case 1:
                Display.printStringList(subTypes);
                int typePoint = ReadKey.readInt(subTypes.size());
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            default:
                Display.printText("Wrong key");
                break;
        }
    }

    public static void main(String[] args) {

    }

}
