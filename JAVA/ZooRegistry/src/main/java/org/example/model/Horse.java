package org.example.model;

import java.time.LocalDate;

public class Horse extends Sumpters {

    public Horse(String Name, LocalDate BirthDay) {
        super(Name, BirthDay);
    }

    public Horse(String Name, LocalDate BirthDay, int loadCapacity) {
        super(Name, BirthDay, loadCapacity);
    }


}
