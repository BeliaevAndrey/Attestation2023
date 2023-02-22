package org.example.controller.services;

public class Counter implements AutoCloseable {

    public static int animalCount = 0;
    boolean isClosed;

    Counter() {
        isClosed = false;
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
