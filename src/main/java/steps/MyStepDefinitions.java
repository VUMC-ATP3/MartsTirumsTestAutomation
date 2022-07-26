package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MyStepDefinitions {

    private int appleCount;
    private int eatenAppleCount;

    @Given("I have {int} apples")
    public void i_have_apples(int int1) {
        System.out.println("I have " + int1 + " apples");
        appleCount = int1;
    }
    @When("I eat {int} apples")
    public void i_eat_apples(int int1) {
        System.out.println("I eat " + int1 + " apples");
        eatenAppleCount = int1;
    }
    @Then("I have {int} apples left")
    public void i_have_apples_left(int int1) {
        System.out.println("I have" + int1 + " apples left");
        int applesLeft = appleCount - eatenAppleCount;
        Assert.assertEquals(applesLeft,int1);
    }

}
