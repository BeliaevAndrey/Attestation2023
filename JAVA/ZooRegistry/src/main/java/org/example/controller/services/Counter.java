package org.example.controller.services;

public class Counter implements AutoCloseable {

    private static int animalCount = 0;
    private static boolean isClosed;

    Counter() {
        isClosed = false;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public static boolean isClosed(){
        return isClosed;
    }
    public void add() {
        if (isClosed) {
            throw new IllegalStateException("Counter-resource is closed!");
        }
        animalCount++;
    }

    @Override
    public void close() throws Exception {
        isClosed = true;
    }
}
