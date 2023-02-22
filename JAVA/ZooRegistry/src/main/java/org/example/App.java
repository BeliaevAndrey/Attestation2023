package org.example;

import org.example.controller.Controller;
import org.example.view.Menu;

public class App {
    public static void main(String[] args) {
        Controller controller = new Controller();
        boolean flag = controller.initZoo();
        if (flag)
            Menu.mainLoop();
    }
}