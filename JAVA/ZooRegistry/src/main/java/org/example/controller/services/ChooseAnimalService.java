package org.example.controller.services;

import org.example.model.Animal;
import org.example.view.Display;
import org.example.view.ReadKey;

import java.util.List;
import java.util.stream.Collectors;

public class ChooseAnimalService {

    public static String chooseSubType() {
        Display.printText(String.format("%4d   Выход", 0));
        List<String> subTypes = ZooIndexService.getAnimalSubTypesAsList();
        Display.printStringList(subTypes);
        int point = ReadKey.readInt(subTypes.size());
        if (point == 0)
            return "exit";
        return subTypes.get(point - 1);
    }


    private static List<Animal> generateSubTypeList(String subType) {
        return ZooIndexService.animalsList.stream().
                filter(animal -> (animal.getClass().getSimpleName() + "s").equals(subType)
                ).collect(Collectors.toList());
    }

    public static Animal chooseAnimal() {
        String subType = chooseSubType();
        if (subType.equalsIgnoreCase("exit"))
            return null;
        List<Animal> animals = generateSubTypeList(subType);
        Display.printText("Выберите животное:");
        Display.printText(String.format("%4d   Выход", 0));
        Display.printAnimalList(animals);
        int point = ReadKey.readInt(animals.size());
        if (point == 0)
            return null;
        return animals.get(point - 1);
    }

}
