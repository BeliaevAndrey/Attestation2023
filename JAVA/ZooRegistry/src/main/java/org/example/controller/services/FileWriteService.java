package org.example.controller.services;

import org.example.model.Animal;

import java.io.BufferedReader;
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
        String animalLine = animal.getFileRecordLine();
        try (BufferedWriter bfw = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND)) {
            bfw.write(animalLine);
            bfw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileUpdate(Animal animal, String oldRecord) {
        String fileName = animal.getClass().getSimpleName() + "s";
        Path filePath = Paths.get(indexDirPath.toString(), fileName);
        StringBuilder buffer = new StringBuilder();
        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
            while (bufferedReader.ready()) {
                String tmp = bufferedReader.readLine();
                if (tmp.equals(oldRecord.strip())) {
                    tmp = animal.getFileRecordLine();
                }
                buffer.append(tmp).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath)) {
            bufferedWriter.write(buffer.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
