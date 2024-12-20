package org.example;

public class Main {
    public static void main(String[] args) {
        // Ініціалізація фасаду
        ProductionFacade productionFacade = new ProductionFacade();

        try {
            // Сценарій: Запуск виробничої лінії
            System.out.println("=== Сценарій: Запуск виробничої лінії ===");
            productionFacade.startLine();
            System.out.println("Лінія запущена.");

            // Сценарій: Зупинка виробничої лінії
            System.out.println("=== Сценарій: Зупинка виробничої лінії ===");
            productionFacade.stopLine();
            System.out.println("Лінія зупинена.");

            // Сценарій: Помилка датчика
            System.out.println("=== Сценарій: Помилка датчика ===");
            productionFacade.setSensorFaulty(true);
            productionFacade.startLine(); // Це має викликати виняток
        } catch (IllegalStateException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
