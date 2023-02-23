package org.example.controller.services;

import org.example.model.Animal;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriteService {
    private Path indexDirPath;

    public FileWriteService(Path indexDirPath) {
        this.indexDirPath = indexDirPath;
        System.out.println("FileWriteService INITED " + indexDirPath);
    }


    public void addAnimalToFile(Animal animal) {
        String fileName = animal.getClass().getSimpleName() + "s";
        Path filePath = Paths.get(indexDirPath.toString(), fileName);
        StringBuilder animalLine = new StringBuilder(animal.getName());
        animalLine.append(";");
        animalLine.append(animal.getBirthDay()).append(";");
        animal.getCommands().forEach(command -> {
            animalLine.append(command).append(";");

        });
        try (BufferedWriter bfw = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND)) {
            bfw.append("\n").write(animalLine.toString());
            bfw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
