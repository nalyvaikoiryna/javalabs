package test.java.steps;

import main.java.core.ProductionFacade;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LineManagementSteps {

    private ProductionFacade facade;

    @Given("виробнича лінія зупинена")
    public void productionLineStopped() {
        facade = new ProductionFacade();
        facade.stopLine();
    }

    @When("адміністратор надсилає команду {string}")
    public void administratorSendsCommand(String command) {
        if ("Запустити лінію".equals(command)) {
            facade.startLine();
        } else {
            throw new IllegalArgumentException("Невідома команда: " + command);
        }
    }

    @Then("конвеєр починає рух")
    public void conveyorStarts() {
        assert facade.isConveyorRunning() : "Конвеєр не працює!";
    }

    @Then("робот виконує свою операцію")
    public void robotPerformsOperation() {
        assert facade.isRobotOperating() : "Робот не виконує операцію!";
    }

    @Then("датчик сигналізує про завершення операції")
    public void sensorSignalsCompletion() {
        assert facade.isOperationComplete() : "Датчик не сигналізує завершення!";
    }
}
