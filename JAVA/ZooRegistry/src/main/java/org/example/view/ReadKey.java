package org.example.view;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadKey {

    public static int readInt(int lim) {
        while (true) {
            int value = readInt();
            if (value <= lim)
                return value;
            else System.out.println("Неверный ввод -- число за пределами списка");
        }
    }

    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(readLine());
            } catch (NumberFormatException e) {
                System.out.println("wrong format");
            }
        }
    }

    public static String readLine() {
        return new Scanner(System.in).nextLine();
    }

    public static LocalDate readDate() {
        Pattern dt = Pattern.compile("\\d{4}.\\d{1,2}.\\d{1,2}");
        String date = null;
        while (true) {
            date = new Scanner(System.in).nextLine();
            Matcher match = dt.matcher(date);
            if (date.equalsIgnoreCase("exit"))
                return null;
            if (match.matches()) {
                date = date.replaceAll("\\D", "-");
                if (date.length() != 10) {
                    String[] tmp = date.split("-");
                    for (int i = 0; i < 3; i++) {
                        if (tmp[1].length() < 2)
                            tmp[1] = "0" + tmp[1];
                        if (tmp[2].length() < 2)
                            tmp[2] = "0" + tmp[2];
                    }
                    date = String.join("-", tmp);
                }
                try {
                    return LocalDate.parse(date);
                } catch (DateTimeException e) {
                    Display.printText("Ошибка парсера даты:");
                    Display.printText(e.getMessage());
                }
            } else Display.printText("Неверный формат, повторите пожалуйста.");
        }
    }

}
