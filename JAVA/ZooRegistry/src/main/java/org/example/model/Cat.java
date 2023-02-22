package org.example.model;

import java.time.LocalDate;

public class Cat extends Pets {

    Cat(String Name, LocalDate BirthDay) {
        super(Name, BirthDay);
    }

    @Override
    protected void addCommand() {

    }

}
