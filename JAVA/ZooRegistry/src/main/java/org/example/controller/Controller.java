package org.example.controller;

import org.example.controller.services.AddAnimalService;
import org.example.controller.services.DirWalkService;
import org.example.controller.services.TeachAnimalService;
import org.example.controller.services.ZooIndexService;
import org.example.view.Display;
import org.example.view.ReadKey;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Controller {
    private Path indexDirPath;
    String INDEX_DIR = "animals_data";
    ZooIndexService zis;

    private final TeachAnimalService teachAnimalService;
    private final AddAnimalService addAnimalService;

    public Controller() {
        this.teachAnimalService = new TeachAnimalService();
        this.addAnimalService = new AddAnimalService();

    }

    public void teachAnimal(){
        teachAnimalService.startTeaching(chooseSubType());
    }
    public void addAnimal(){
        addAnimalService.fillParameters(chooseSubType());
    }
    public boolean initZoo() {
        try {
            walkRootPath(Path.of(System.getProperty("user.dir")));
            zis = new ZooIndexService(indexDirPath);
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

    public String chooseSubType() {
        List<String> subTypes = ZooIndexService.getAnimalSubTypesAsList();
        Display.printStringList(subTypes);
        String animal = subTypes.get(ReadKey.readInt() - 1);
        Display.printText("Your choice: " + animal);
        return animal;
    }


}
