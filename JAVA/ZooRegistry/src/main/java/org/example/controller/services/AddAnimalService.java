package org.example.controller.services;

import org.example.controller.Controller;
import org.example.model.Animal;
import org.example.model.Commands;
import org.example.view.Display;
import org.example.view.ReadKey;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddAnimalService {

    Controller controller;
    public AddAnimalService(Controller controller){
        this.controller = controller;
    }

    public void fillParameters(String subType) {
        Animal newAnimal;
        List<String> commandsList;
        Display.showPrompt("Введите Имя:");
        String name = ReadKey.readLine();
        Display.showPrompt("Введите Дату рождения (формат ГГГГ-ММ-ДД):");
        LocalDate birthday = ReadKey.readDate();
        Display.printText(CommandsService.getCommandList());
        Display.showPrompt("Введите коды команды, которым обучено животное через зяпятую (exit, если неграмотное):");
        while (true) {
            try {
                String commands = ReadKey.readLine();
                commandsList = parseCommands(commands);
                break;
            }catch (Exception e) {
                Display.printText("Неверый ввод, повторите пожалуйста.");
            }
        }
        newAnimal = new AnimalService().createAnimalObject(subType, name, birthday, commandsList);
        Display.printText(newAnimal.getData());
        Display.showPrompt("Сохранить? [Y/N]");
        String answer = ReadKey.readLine();
        if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("YES")) {
            try (Counter cnt = new Counter()) {
                // Счётчик с ресурсами
                cnt.add();
            } catch (Exception ignored) {
            }
            ZooIndexService.animalsList.add(newAnimal);
            controller.writeAnimalToFile(newAnimal);
            Display.printText("Сохранено.");
        } else if (answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("NO")) {
            Display.printText("Ok.");
        }
        if (!Counter.isClosed())
            throw new RuntimeException("COUNTER WAS NOT CLOSED!");
    }

    private List<String> parseCommands(String line) throws NumberFormatException {
        List<String> commands = new ArrayList<>();
        String[] codes = line.replaceAll("\\s", "").split("\\D");
        Arrays.stream(codes).forEach(num -> {
            commands.add(Commands.values()[Integer.parseInt(num)].command);
        });
        return commands;

    }

}

