package org.example;

public class Robot {
    private boolean operating = false;

    public void start() {
        operating = true;
        System.out.println("Робот виконує операцію.");
    }

    public void stop() {
        operating = false;
        System.out.println("Робот зупинено.");
    }

    public boolean isOperating() {
        return operating;
    }
}
