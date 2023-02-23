package org.example.controller.services;

import org.example.model.Animal;
import org.example.view.Display;
import org.example.view.ReadKey;

import java.time.LocalDate;
import java.util.List;

public class AddAnimalService {


    public void fillParameters(String subType) {
        Display.showPrompt("Введите Имя:");
        String name = ReadKey.readLine();
        Display.showPrompt("Введите Дату рождения (формат ГГГГ-ММ-ДД):");
        LocalDate birthday = ReadKey.readDate();
        Display.showPrompt("Введите команды, которым обучено животное через зяпятую (exit, если неграмотное):");
        String commands = ReadKey.readLine();
        Animal newAnimal;
        List<String> commandsList;

        if (!commands.isBlank() && !commands.isEmpty() && !commands.equalsIgnoreCase("exit")) {
            commandsList = List.of(commands.split(","));
            newAnimal = new AnimalService().createAnimalObject(subType, name, birthday, commandsList);
            try (Counter cnt = new Counter()) {
                cnt.add();
            } catch (Exception ignored) {}
        } else {
            newAnimal = new AnimalService().createAnimalObject(subType, name, birthday);
        }
        ZooIndexService.animalsList.add(newAnimal);
    }

//    public static void main(String[] args) {    // TODO: REMOVE CRUTCH
//        AddAnimalService aas = new AddAnimalService();
//        aas.fillParameters(aas.chooseSubType());
//    // Аллигатор
//    // 2022-12-09
//    // сидеть, лежать, голос, прыгать, лирически зывывать
//
//    }
}

