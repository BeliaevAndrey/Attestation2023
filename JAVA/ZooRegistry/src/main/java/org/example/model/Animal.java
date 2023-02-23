package org.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    String name;
    LocalDate birthDay;
    List<String> commands = null;

    Animal(String name, LocalDate birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    protected void learnCommand() {

    }

    public void addCommands(List<String> commands) {
        this.commands = commands;
    }

    LocalDate getBirthDay() {
        return this.birthDay;
    }

    public List<String> getCommands() {
        if (this.commands != null)
            return this.commands;
        return new ArrayList<>();
    }

    String getAge() {
        int years = (int) getDoubleAge();
        int months = (int) (getDoubleAge() % 1 * 12);
        return String.format("Возраст: %d год(а) %d месяц(ев)", years, months);
    }

    double getDoubleAge() {
        double ttlYears = (LocalDate.now().getYear() - birthDay.getYear()) * 12 +
                (LocalDate.now().getMonth().getValue() - birthDay.getMonth().getValue());
        return ttlYears / 12;
    }


    @Override
    public String toString() {
        return String.format("%s\t%s\t%s",
                name, birthDay.toString(), this.getClass().getSimpleName());
    }
}
