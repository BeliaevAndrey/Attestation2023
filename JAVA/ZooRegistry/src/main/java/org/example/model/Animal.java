package org.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;

public abstract class Animal {
    private final String name;
    private final LocalDate birthDay;
    private List<String> commands = null;

    Animal(String name, LocalDate birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    public void learnCommand() {

    }

    public void addCommands(List<String> commands) {
        this.commands = commands;
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


    public String getData() {
        StringBuilder passport = new StringBuilder("_".repeat(40));
        passport.append("\n");
        passport.append(String.format("%15s: ", "Имя")).append(name).append("\n");
        passport.append(String.format("%15s: ", "Дата рождения")).append(birthDay).append("\n");
        passport.append(String.format("%15s:\n", "Знает команды"));
        if (commands.size() > 0)
            commands.forEach(c -> {
                passport.append(String.format("%38s", c)).append("\n");
            });
        else passport.append(String.format("%38s\n", "необученный"));
        passport.append("_".repeat(40)).append("\n");
        return passport.toString();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDay() {
        return this.birthDay;
    }
    @Override
    public String toString() {
        return String.format("%s\t%s\t%s",
                name, birthDay.toString(), this.getClass().getSimpleName());
    }
}
