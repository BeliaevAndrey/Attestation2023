package org.example;

import org.example.controller.Controller;
import org.example.view.Display;
import org.example.view.Menu;

public class App {
    public static void main(String[] args) {
        Controller controller = new Controller();
        if (controller.zooInitFlag)
            Menu.mainLoop();
        else Display.printText("ERROR ZOO INITALIZATION!");
    }
}