package org.example.controller.services;

import org.example.model.Animal;
import org.example.model.Commands;
import org.example.view.Display;
import org.example.view.ReadKey;

import java.util.List;
import java.util.stream.Collectors;

public class TeachAnimalService {

    public void startTeaching(String subType) {
        List<Animal> animals = ZooIndexService.animalsList.stream().
                filter(animal -> (animal.getClass().getSimpleName() + "s").equals(subType)
                ).collect(Collectors.toList());
        System.out.println("animals 1 " + animals);
        Animal animal = chooseAnimal(animals);
        System.out.println(animal);
        chooseCommand();
    }

    Animal chooseAnimal(List<Animal> animals) {
        System.out.println("animals 2 " + animals);
        Display.printText("Выбрать животное для обучения:");
        Display.printText(String.format("%4d   Выход", 0));
        Display.printAnimalList(animals);

        int point = ReadKey.readInt(animals.size());
        if (point == 0)
            return null;
        return animals.get(point - 1);
    }

    void chooseCommand() {
        StringBuilder sb = new StringBuilder();
        for (Commands cmd : Commands.values()) {
            sb.append(cmd.ordinal()).
                    append("\t").append(cmd.command).append("\n");
        }
        Display.printText(sb.toString());
    }
}


