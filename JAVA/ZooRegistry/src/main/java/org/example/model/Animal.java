package org.example.model;

import java.time.LocalDate;
import java.util.List;

public abstract class Animal {
    String Name;
    LocalDate birthDay;
    List<String> commands = null;

    Animal(String Name, LocalDate BirthDay) {
        this.Name = Name;
        this.birthDay = BirthDay;
    }

    protected abstract void addCommand();
    LocalDate getBirthDay() {
        return this.birthDay;
    }
    List<String> getCommands(){
        return this.commands;
    }

    String getAge() {
        int years = (int) getDoubleAge();
        int months =  (int)(getDoubleAge() % 1 * 12);
        return String.format("Возраст: %d год(а) %d месяц(ев)", years, months);
    }

    double getDoubleAge() {
        double ttlYears = (LocalDate.now().getYear() - birthDay.getYear()) * 12 +
                (LocalDate.now().getMonth().getValue() - birthDay.getMonth().getValue());
        return ttlYears / 12;
    }


}
