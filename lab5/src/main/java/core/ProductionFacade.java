package main.java.core;

public class ProductionFacade {
    private Conveyor conveyor = new Conveyor();
    private Robot robot = new Robot();
    private Sensor sensor = new Sensor();

    public void startLine() {
        conveyor.start();
        robot.start();
        sensor.activate();
    }

    public void stopLine() {
        conveyor.stop();
        robot.stop();
        sensor.deactivate();
    }

    public boolean isConveyorRunning() {
        return conveyor.isRunning();
    }

    public boolean isRobotOperating() {
        return robot.isOperating();
    }

    public boolean isOperationComplete() {
        return sensor.isOperationComplete();
    }
}
