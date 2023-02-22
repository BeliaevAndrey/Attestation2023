package org.example.controller.services;


import org.example.model.Animal;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LoadAnimalsService {

    private Path indexDirPath;
    private AnimalService animalService = new AnimalService();

    public LoadAnimalsService(Path path) {
        this.indexDirPath = path;
        walkAroundAnimals();
    }

    public void walkAroundAnimals() {
        for (String subType : ZooIndexService.animalSubTypes.keySet()) {
            if (ZooIndexService.animalSubTypes.get(subType) != -1) {
                loadAnimals(subType);
            }
        }
    }

    private void loadAnimals(String subType) {
        Path filePath = Paths.get(indexDirPath.toString(), subType);
        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (!line.isEmpty() && !line.isBlank())
                    enlistAnimal(subType, line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void enlistAnimal(String subType, String record) {
        String[] parameters = record.split(";");
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = parameters[i].strip();
        }
        String name = parameters[0];
        LocalDate birthDay;
        try {
            birthDay = LocalDate.parse(parameters[1]);
        } catch (DateTimeException e) {
            System.out.println(e.getMessage());
            return;
        }
        Animal newAnimal = animalService.createAnimalObject(subType, name, birthDay);
        if (parameters.length > 2) {
            newAnimal.addCommands(Arrays.stream(parameters).collect(Collectors.toList()));
        }
        System.out.println(newAnimal.toString());
        ZooIndexService.animalsList.add(newAnimal);
        int subTypeCount = ZooIndexService.animalSubTypes.get(subType);
        ZooIndexService.animalSubTypes.put(subType, subTypeCount + 1);
        try (Counter cnt = new Counter()) {
            // Счётчик с ресурсами
            cnt.add();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!Counter.isClosed())
            throw new RuntimeException("COUNTER WAS NOT CLOSED!");
    }

}
