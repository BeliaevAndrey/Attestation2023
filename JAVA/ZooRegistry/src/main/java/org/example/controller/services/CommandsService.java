package org.example.controller.services;

import org.example.model.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandsService {

    public static String getCommandList(){
        StringBuilder sb = new StringBuilder(
                String.format("%4s%12s%12s\n", "Код", "Команда", "Alias")
        );
        sb.append("_".repeat(28)).append("\n");
        Arrays.stream(Commands.values()).forEach(c -> {
            sb.append(String.format("%4d", c.ordinal()));
            sb.append(String.format("%12s", c.command));
            sb.append(String.format("%12s",c)).append("\n");
        });
        sb.append("_".repeat(28)).append("\n");
        return sb.toString();
    }

    public static List<String> parseCommands(String line) throws NumberFormatException {
        List<String> commands = new ArrayList<>();
        String[] codes = line.replaceAll("\\s", "").split("\\D");
        Arrays.stream(codes).forEach(num -> {
            commands.add(Commands.values()[Integer.parseInt(num)].command);
        });
        return commands;
    }

}
