package org.example.controller;

import org.example.controller.services.*;
import org.example.model.Animal;
import org.example.view.Display;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Controller {
    private Path indexDirPath;
    String INDEX_DIR = "animals_data";
    ZooIndexService zis;

    private final TeachAnimalService teachAnimalService;
    private final AddAnimalService addAnimalService;
    private final FileWriteService fileWriteService;

    public boolean zooInitFlag;


    public Controller() {
        zooInitFlag = initZoo();
        this.teachAnimalService = new TeachAnimalService(this);
        this.addAnimalService = new AddAnimalService(this);
        this.fileWriteService = new FileWriteService(this.indexDirPath);
    }

    public void teachAnimal() {
        Animal animal = ChooseAnimalService.chooseAnimal();
        if (animal == null)
            return;
        teachAnimalService.startTeaching(animal);
    }

    public void addAnimal() {
        String choice = ChooseAnimalService.chooseSubType();
        if (choice.equalsIgnoreCase("exit"))
            return;
        addAnimalService.fillParameters(choice);
    }

    public void showAnimalData() {
        Animal animal = ChooseAnimalService.chooseAnimal();
        if (animal == null)
            return;
        Display.printText(animal.getData());
    }

    public void writeAnimalToFile(Animal animal) {
        fileWriteService.addAnimalToFile(animal);
    }

    public void updateAnimalInFile(Animal animal, String oldRecord) {
        System.out.println(" ".repeat(30) + oldRecord);
        fileWriteService.fileUpdate(animal, oldRecord);
    }

    public boolean initZoo() {
        try {
            walkRootPath(Path.of(System.getProperty("user.dir")));
            zis = new ZooIndexService(indexDirPath);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void walkRootPath(Path path) {
        indexDirPath = DirWalkService.search(path, INDEX_DIR);
        if ((indexDirPath == null)) {
            try {
                Files.createDirectory(Paths.get(path.toString(), INDEX_DIR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
