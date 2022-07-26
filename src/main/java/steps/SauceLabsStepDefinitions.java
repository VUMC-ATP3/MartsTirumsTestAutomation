package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjectsHomework.*;

import java.time.Duration;

public class SauceLabsStepDefinitions {

    WebDriver driver;
    LoginPage loginPage;


    @Before("@browser")
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @After("@browser")
    public void tearDown(){
        driver.close();
    }

    @Given("user is navigated to {string}")
    public void user_is_navigated_to(String url) {
        driver.get(url);
    }

    @Then("user sees page title {string}")
    public void user_sees_page_title(String pageTitle) {
        Assert.assertEquals(driver.getTitle(), pageTitle);
    }

    @When("user enters username {string} and password {string}")
    public void userEntersUsernameUsernameAndPasswordPassword(String username, String password) {
        loginPage.getUsernameField().sendKeys(username);
        loginPage.getPasswordField().sendKeys(password);
    }
    @And("user clicks login button")
    public void userNameClicksLoginButton(){
        loginPage.getLoginButton().click();
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getProductTitle().getText(),"PRODUCTS");
    }

    @Then("user sees error message {string}")
    public void user_sees_error_message(String errorMessage) {
        Assert.assertEquals(loginPage.getErrorText().getText(), errorMessage);

    }

    @When("user adds item to cart")
    public void user_adds_item_to_cart() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.getProductOnesie().click();
    }
    @When("user clicks cart button")
    public void user_clicks_cart_button() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.getCartButton().click();
    }
    @When("user clicks checkout button")
    public void user_clicks_checkout_button() {
        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();
    }
    @When("user enter name {string} and Lastname {string} and zip {string}")
    public void user_enter_name_and_lastname_and_zip(String name, String lastname, String zip) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.yourInformation(name, lastname, zip);
    }
    @When("user clicks continue button")
    public void user_clicks_continue_button() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getContinueButton().click();
    }
    @When("user clicks finish button")
    public void user_clicks_finish_button() {
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.getFinishButton().click();
    }
    @Then("order is created successfully")
    public void order_is_created_successfully() {
        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
        Assert.assertEquals(checkoutSuccessPage.getPageTitle().getText(),"CHECKOUT: COMPLETE!");
        checkoutSuccessPage.getBackHomeButton().click();
    }
    @Then("user sees error {streing}")
    public void userSeesErrorMessage(String errorMessage){
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(),errorMessage);
    }



}
