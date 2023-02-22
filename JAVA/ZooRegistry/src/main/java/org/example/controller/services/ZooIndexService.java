package org.example.controller.services;

import org.example.model.Animal;

import java.util.List;

public class ZooIndexService {
//    public static List<String> animalTypes = List.of("Sumpters", "Pets");
    public static List<String> animalSubTypes = List.of("Cats", "Dogs", "Hamsters", "Donkeys", "Horses", "Camels");
    public static List<Animal> animalsList;

    public ZooIndexService() {

    }

    @Override
    public String toString() {  // TODO: Temporary stub. Replace with correct method(s)
        StringBuilder sb = new StringBuilder();
        animalSubTypes.forEach(animal -> sb.append(animal).append('\n'));
        return sb.toString();
    }

}
