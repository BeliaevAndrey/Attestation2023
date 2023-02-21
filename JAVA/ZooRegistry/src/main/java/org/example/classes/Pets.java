package org.example.classes;

import java.time.LocalDate;

public abstract class Pets extends Animal {
    Pets(String Name, LocalDate BirthDay) {
        super(Name, BirthDay);
    }
}
