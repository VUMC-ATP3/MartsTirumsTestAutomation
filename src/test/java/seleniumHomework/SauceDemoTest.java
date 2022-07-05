package seleniumHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

import java.time.Duration;

public class SauceDemoTest {

    WebDriver driver;
    private final String SWAGLABS = "https://www.saucedemo.com/";

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();

    }

    @Test
    public void testScenarioOne() throws InterruptedException {
        driver.get(SWAGLABS);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getProductTitle().getText(),"PRODUCTS");
        System.out.println("login successful");
        inventoryPage.getProductOnesie().click();
        inventoryPage.getCartButton().click();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getTestOnesieInCart().getText(),"Sauce Labs Onesie");
        System.out.println("Onesie in cart successful");
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.yourInformation("Marts", "Tirums", "LV2127");
        checkoutPage.getContinueButton().click();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(checkoutOverviewPage.getOverviewTitle().getText(),"CHECKOUT: OVERVIEW");
        Assert.assertEquals(checkoutOverviewPage.getProductOnesie().getText(),"Sauce Labs Onesie");
        System.out.println("Checkout overview successful");
        checkoutOverviewPage.getFinishButton().click();

        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
        Assert.assertEquals(checkoutSuccessPage.getPageTitle().getText(),"CHECKOUT: COMPLETE!");
        Assert.assertEquals(checkoutSuccessPage.getThankYouText().getText(),"THANK YOU FOR YOUR ORDER");
        System.out.println("Checkout complete successful");
        checkoutSuccessPage.getBackHomeButton().click();

        Thread.sleep(3000);
    }

    @Test
    public void testScenarioTwo() throws InterruptedException {
        driver.get(SWAGLABS);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.getEmptyCartButton().click();

        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorFirstName().getText(),"Error: First Name is required");

        checkoutPage.yourInformation("Marts","","");

        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorLastName().getText(),"Error: Last Name is required");

        checkoutPage.yourInformation("","Tirums","");

        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorZipPostalCode().getText(),"Error: Postal Code is required");


        Thread.sleep(3000);

    }






}
