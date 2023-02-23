package org.example.controller.services;

import org.example.controller.Controller;
import org.example.model.Animal;
import org.example.view.Display;
import org.example.view.ReadKey;

import java.util.List;

public class TeachAnimalService {

    private Controller controller;

    public TeachAnimalService(Controller controller) {
        this.controller = controller;
    }

    public void startTeaching(Animal animal) {
        Display.printText(animal.getData());
        String oldRecord = animal.getFileRecordLine();
        if (animal.learnCommand(chooseCommand())) {
            Display.printText(animal.getData());
            Display.showPrompt("Сохранить на диск (команды сохранятся до конца сессии)? [Y/N]");
            String answer = ReadKey.readLine();
            if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("YES")) {
                controller.updateAnimalInFile(animal, oldRecord);
                Display.printText("Сохранено.");
            } else if (answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("NO")) {
                Display.printText("Ok. Changes Dropped.");
            } else {
                Display.printText("Неверный ввод");
            }
        }

    }

    private List<String> chooseCommand() {
        List<String> commandsList;
        Display.printText(CommandsService.getCommandList());
        Display.showPrompt("Введите коды команды, через зяпятую (exit -- отмена):");
        while (true) {
            try {
                String commands = ReadKey.readLine();
                commandsList = CommandsService.parseCommands(commands);
                break;
            } catch (Exception e) {
                Display.printText("Неверый ввод, повторите пожалуйста.");
            }
        }
        return commandsList;

    }
}


