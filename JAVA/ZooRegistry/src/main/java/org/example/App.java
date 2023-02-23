package org.example;

import org.example.controller.Controller;
import org.example.view.Display;
import org.example.view.Menu;

public class App {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Menu menu = new Menu(controller);
        if (controller.zooInitFlag)
            menu.mainLoop();
        else Display.printText("ERROR ZOO INITALIZATION!");
    }
}