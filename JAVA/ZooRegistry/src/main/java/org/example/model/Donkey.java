package org.example.model;

import java.time.LocalDate;

public class Donkey extends Sumpters {

    Donkey(String Name, LocalDate BirthDay) {
        super(Name, BirthDay);
    }

    @Override
    protected void addCommand() {

    }

}
