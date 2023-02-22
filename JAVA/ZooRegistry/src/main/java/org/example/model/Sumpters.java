package org.example.model;

import java.time.LocalDate;

public abstract class Sumpters extends Animal{

    private int weight;

    Sumpters(String Name, LocalDate BirthDay) {
        super(Name, BirthDay);
    }
}
