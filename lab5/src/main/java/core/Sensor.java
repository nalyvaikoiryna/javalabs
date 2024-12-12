package main.java.core;

public class Sensor {
    private boolean operational = true;

    public void activate() {
        if (!operational) {
            throw new RuntimeException("Датчик не працює!");
        }
        System.out.println("Датчик активовано.");
    }

    public void deactivate() {
        System.out.println("Датчик деактивовано.");
    }

    public boolean isOperationComplete() {
        return true;
    }
}
