package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConveyorTest {

    @Test
    public void testStart() {
        Conveyor conveyor = new Conveyor();
        conveyor.start();
        assertTrue(conveyor.isRunning(), "Конвеєр має працювати після запуску.");
    }

    @Test
    public void testStop() {
        Conveyor conveyor = new Conveyor();
        conveyor.start();
        conveyor.stop();
        assertFalse(conveyor.isRunning(), "Конвеєр має бути зупиненим після виклику stop.");
    }
}
