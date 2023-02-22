package org.example.controller.services;

import org.example.model.*;

import java.time.LocalDate;
import java.util.List;

public class AnimalService {

    public Animal createAnimalObject(String type, String name, LocalDate birthDay) {
        switch (type){
            case "Cats":
                return new Cat(name, birthDay);
            case "Dogs":
                return new Dog(name, birthDay);
            case "Hamsters":
                return new Hamster(name, birthDay);
            case "Camels":
                return new Camel(name, birthDay);
            case "Horses":
                return new Horse(name, birthDay);
            case "Donkeys":
                return new Donkey(name, birthDay);
            default:
                return null;
        }
    }


}
