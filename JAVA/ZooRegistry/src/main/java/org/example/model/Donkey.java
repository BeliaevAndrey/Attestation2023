package org.example.model;

import java.time.LocalDate;

public class Donkey extends Sumpters {

    public Donkey(String Name, LocalDate BirthDay) {
        super(Name, BirthDay);
    }
    public Donkey(String Name, LocalDate BirthDay, int loadCapacity) {
        super(Name, BirthDay, loadCapacity);
    }



}
