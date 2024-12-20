package org.example;

public class Sensor {
    private boolean operational = true; // Стан датчика: працює чи несправний

    // Активує датчик, якщо він справний
    public void activate() {
        if (!operational) {
            throw new IllegalStateException("Датчик не працює!");
        }
        System.out.println("Датчик активовано.");
    }

    // Деактивує датчик
    public void deactivate() {
        System.out.println("Датчик деактивовано.");
    }

    // Перевіряє, чи датчик сигналізує завершення операції
    public boolean isOperationComplete() {
        return operational; // Повертає true, якщо датчик справний
    }

    // Встановлює стан датчика (працює/не працює)
    public void setOperational(boolean operational) {
        this.operational = operational;
    }

    // Перевіряє, чи датчик справний
    public boolean isOperational() {
        return operational;
    }
}
