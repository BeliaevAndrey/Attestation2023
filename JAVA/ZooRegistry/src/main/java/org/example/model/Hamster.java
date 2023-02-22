package org.example.model;

import java.time.LocalDate;

public class Hamster extends Pets {

    Hamster(String Name, LocalDate BirthDay) {
        super(Name, BirthDay);
    }

    @Override
    protected void addCommand() {

    }

}
