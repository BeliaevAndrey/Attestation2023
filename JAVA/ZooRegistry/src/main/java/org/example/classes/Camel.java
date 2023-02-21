package org.example.classes;

import java.time.LocalDate;
import java.util.List;

public class Camel extends Sumpters {

    Camel(String Name, LocalDate BirthDay) {
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
