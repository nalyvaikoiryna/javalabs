package org.example;

public class Sensor {
    private boolean operational = true; // Стан датчика: працює чи несправний


    public void activate() {
        if (!operational) {
            throw new IllegalStateException("Датчик не працює!");
        }
        System.out.println("Датчик активовано.");
    }

    public void deactivate() {
        System.out.println("Датчик деактивовано.");
    }

    public boolean isOperationComplete() {
        return operational; // Повертає true, якщо датчик справний
    }

    public void setOperational(boolean operational) {
        this.operational = operational;
    }

    public boolean isOperational() {
        return operational;
    }
}
