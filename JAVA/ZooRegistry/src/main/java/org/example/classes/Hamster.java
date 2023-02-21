package org.example.classes;

import java.time.LocalDate;
import java.util.List;

public class Hamster extends Pets {

    Hamster(String Name, LocalDate BirthDay) {
        super(Name, BirthDay);
    }

    @Override
    void addCommand() {

    }

    @Override
    LocalDate getBirthDay() {
        return null;
    }

    @Override
    List<String> getCommands() {
        return null;
    }
}
