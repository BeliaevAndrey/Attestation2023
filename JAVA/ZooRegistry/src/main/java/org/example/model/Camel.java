package org.example.model;

import java.time.LocalDate;

public class Camel extends Sumpters {

    public Camel(String Name, LocalDate BirthDay) {
        super(Name, BirthDay);
    }
    public Camel(String Name, LocalDate BirthDay, int loadCapacity) {
        super(Name, BirthDay, loadCapacity);
    }


}
