package org.example.model;

import java.time.LocalDate;

public abstract class Sumpters extends Animal{

    protected int loadCapacity;
    Sumpters(String Name, LocalDate BirthDay) {
        super(Name, BirthDay);
    }

    Sumpters(String Name, LocalDate BirthDay, int loadCapacity) {
        super(Name, BirthDay);
        this.loadCapacity = loadCapacity;
    }
}
