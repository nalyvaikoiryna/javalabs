package main.java.core;

public class Conveyor {
    private boolean running = false;

    public void start() {
        running = true;
        System.out.println("Конвеєр запущено.");
    }

    public void stop() {
        running = false;
        System.out.println("Конвеєр зупинено.");
    }

    public boolean isRunning() {
        return running;
    }
}
