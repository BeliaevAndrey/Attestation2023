package org.example.model;

import java.time.LocalDate;

public class Dog extends Pets {

    Dog(String Name, LocalDate BirthDay) {
        super(Name, BirthDay);
    }

    @Override
    protected void addCommand() {

    }

}
