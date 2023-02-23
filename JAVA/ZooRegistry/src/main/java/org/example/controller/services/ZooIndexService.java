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
        las.startLoadAnimals();
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
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public static List<String> getAnimalSubTypesAsList() {
        return new ArrayList<>(animalSubTypes.keySet());
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Subtypes: \n");
        animalSubTypes.keySet().forEach(animalType -> sb.append(animalType).append('\n'));
        sb.append("\nAnimals:\n");
        animalsList.forEach(animal -> {
            if(animal != null)
                sb.append(animal);
        });
        return sb.toString();
    }

}
