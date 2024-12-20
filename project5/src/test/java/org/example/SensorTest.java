package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SensorTest {

    @Test
    public void testActivateWhenOperational() {
        Sensor sensor = new Sensor();
        assertDoesNotThrow(sensor::activate, "Датчик має активуватися, якщо він справний.");
    }

    @Test
    public void testActivateWhenNotOperational() {
        Sensor sensor = new Sensor();
        sensor.setOperational(false);
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                sensor::activate,
                "Датчик має кидати помилку, якщо він несправний."
        );
        assertEquals("Датчик не працює!", exception.getMessage());
    }

    @Test
    public void testDeactivate() {
        Sensor sensor = new Sensor();
        assertDoesNotThrow(sensor::deactivate, "Деактивація датчика не має викликати помилок.");
    }

    @Test
    public void testSetAndGetOperational() {
        Sensor sensor = new Sensor();
        sensor.setOperational(false);
        assertFalse(sensor.isOperational(), "Датчик має бути несправним.");
        sensor.setOperational(true);
        assertTrue(sensor.isOperational(), "Датчик має бути справним.");
    }
}
