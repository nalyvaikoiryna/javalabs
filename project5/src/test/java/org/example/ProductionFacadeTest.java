package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductionFacadeTest {

    @Test
    public void testStartLine() {
        ProductionFacade facade = new ProductionFacade();
        facade.startLine();

        assertTrue(facade.isConveyorRunning(), "Конвеєр має працювати після запуску.");
        assertTrue(facade.isRobotOperating(), "Робот має працювати після запуску.");
        assertTrue(facade.isOperationComplete(), "Операція має бути завершена.");
    }

    @Test
    public void testStopLine() {
        ProductionFacade facade = new ProductionFacade();
        facade.startLine();
        facade.stopLine();

        assertFalse(facade.isConveyorRunning(), "Конвеєр має бути зупиненим.");
        assertFalse(facade.isRobotOperating(), "Робот має бути зупиненим.");
    }

    @Test
    public void testSensorFault() {
        ProductionFacade facade = new ProductionFacade();
        facade.setSensorFaulty(true);

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                facade::startLine,
                "Має бути кинута помилка, якщо датчик несправний."
        );

        assertEquals("Датчик не працює!", exception.getMessage());
    }
}
