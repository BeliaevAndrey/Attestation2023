package org.example.controller.services;

import org.example.model.Animal;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZooIndexService {
    public static Map<String, Integer> animalSubTypes = new HashMap<>();
    public static List<Animal> animalsList = new ArrayList<>();

    static {
        List.of("Cats", "Dogs", "Hamsters", "Donkeys", "Horses", "Camels").
                forEach(subType -> animalSubTypes.put(subType, -1));
    }

    public ZooIndexService(Path indexDirPath) {
        searchAndCreateFiles(indexDirPath);
        LoadAnimalsService las = new LoadAnimalsService(indexDirPath);
    }

    private void searchAndCreateFiles(Path path) {
        animalSubTypes.keySet().forEach(subType -> {
            Path animalType = Paths.get(path.toString(), subType);
            if (Files.exists(animalType)) {
                animalSubTypes.put(subType, 0);
            }
            else  {
                try {
                    Files.createFile(animalType);
                } catch (Exception e) {
                    System.out.println("!".repeat(100));
                    System.out.println(animalType);
                    System.out.println("!".repeat(100));
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        });


    }

    @Override
    public String toString() {  // TODO: Temporary stub. Replace with correct method(s)
        StringBuilder sb = new StringBuilder();
        sb.append("Subtypes: \n");
        animalSubTypes.keySet().forEach(animalType -> sb.append(animalType).append('\n'));
        sb.append("\nAnimals:\n");
        animalsList.forEach(animal -> {
            System.out.println(animal);
            if(animal != null)
                sb.append(animal);
        });
        return sb.toString();
    }

}
