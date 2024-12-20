package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {

    @Test
    public void testStart() {
        Robot robot = new Robot();
        robot.start();
        assertTrue(robot.isOperating(), "Робот має працювати після запуску.");
    }

    @Test
    public void testStop() {
        Robot robot = new Robot();
        robot.start();
        robot.stop();
        assertFalse(robot.isOperating(), "Робот має бути зупиненим після виклику stop.");
    }
}
