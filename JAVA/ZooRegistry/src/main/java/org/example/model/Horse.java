package org.example.model;

import java.time.LocalDate;

public class Horse extends Sumpters {

    Horse(String Name, LocalDate BirthDay) {
        super(Name, BirthDay);
    }

    @Override
    protected void addCommand() {

    }

}
