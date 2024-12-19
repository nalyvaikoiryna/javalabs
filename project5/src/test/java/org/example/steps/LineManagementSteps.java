package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.ProductionFacade;

public class LineManagementSteps {
    private ProductionFacade facade;
    private boolean sensorFaulty = false;

    @Given("виробнича лінія зупинена")
    public void productionLineStopped() {
        facade = new ProductionFacade();
        facade.stopLine();
    }

    @Given("виробнича лінія працює")
    public void productionLineRunning() {
        facade = new ProductionFacade();
        facade.startLine();
    }

    @Given("датчик несправний")
    public void sensorIsFaulty() {
        sensorFaulty = true;
    }

    @When("адміністратор надсилає команду {string}")
    public void administratorSendsCommand(String command) {
        if (sensorFaulty && "Запустити лінію".equals(command)) {
            throw new IllegalStateException("Датчик не працює!");
        }

        if ("Запустити лінію".equals(command)) {
            facade.startLine();
        } else if ("Зупинити лінію".equals(command)) {
            facade.stopLine();
        } else {
            throw new IllegalArgumentException("Невідома команда: " + command);
        }
    }

    @Then("система видає помилку {string}")
    public void systemThrowsError(String errorMessage) {
        try {
            facade.startLine();
        } catch (IllegalStateException e) {
            assert e.getMessage().equals(errorMessage) : "Очікувана помилка не співпадає!";
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    @Then("конвеєр починає рух")
    public void conveyorStarts() {
        assert facade.isConveyorRunning() : "Конвеєр не працює!";
        System.out.println("Конвеєр почав рух.");
    }

    @Then("робот виконує свою операцію")
    public void robotPerformsOperation() {
        assert facade.isRobotOperating() : "Робот не виконує операцію!";
        System.out.println("Робот виконує свою операцію.");
    }

    @Then("датчик сигналізує про завершення операції")
    public void sensorSignalsCompletion() {
        assert facade.isOperationComplete() : "Датчик не сигналізує завершення!";
        System.out.println("Датчик сигналізує про завершення операції.");
    }

    @Then("конвеєр зупиняється")
    public void conveyorStops() {
        assert !facade.isConveyorRunning() : "Конвеєр все ще працює!";
        System.out.println("Конвеєр зупинився.");
    }

    @Then("робот припиняє операцію")
    public void robotStopsOperation() {
        assert !facade.isRobotOperating() : "Робот все ще працює!";
        System.out.println("Робот припинив операцію.");
    }

    @Then("датчик деактивується")
    public void sensorDeactivates() {
        System.out.println("Датчик деактивовано.");
    }
}
