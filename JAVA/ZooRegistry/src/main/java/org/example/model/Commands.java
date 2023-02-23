package org.example.model;

public enum Commands {
    VOICE("Голос!"),
    STAY("Стоять!"),
    RUN("Бежать!"),
    LAY("Лежать!"),
    SIT("Сидеть!"),
    SERVE("Служи!"),
    WALK_BY("Рядом!"),
    PAW("Лапу!");

    public final String command;

    Commands(String command){
        this.command = command;
    }
}
