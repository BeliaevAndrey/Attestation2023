package org.example.classes;

import java.time.LocalDate;
import java.util.List;

public class Dog extends Pets {

    Dog(String Name, LocalDate BirthDay) {
        super(Name, BirthDay);
    }

    @Override
    void addCommand() {

    }

}
