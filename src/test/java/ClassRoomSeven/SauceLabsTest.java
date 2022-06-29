package ClassRoomSeven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Footer;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

import java.time.Duration;
import java.util.List;

public class SauceLabsTest {

    WebDriver driver;
    private final String SWAGLABS_URL = "https://www.saucedemo.com/";
    private final String LOCAL_URL = "file://C:\\Users\\Smart\\Desktop\\javalekcija4\\MartsTirumsTestAutomation\\elements.html";

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

////////////////////////////////////////////////////////////////////////////////
    @Test
    public void testErrorMessage() throws InterruptedException {
        driver.get(SWAGLABS_URL);

        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("standard_user");

        WebElement userPassInputField = driver.findElement(By.id("password"));
        userPassInputField.sendKeys("");

        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));     //CSS
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Password is required";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

//        //atsevišķš tests
//        usernameInputField.clear();
//        userPassInputField.sendKeys("Password123");
//        loginButton.click();
//        actualErrorMessage = errorMessage.getText();
//        expectedErrorMessage = "Epic sadface: Username is required";


        Thread.sleep(5000);

    }
// AUgšā garāks apakšā īsāk ar elementiem no main

    @Test
    public void testErrorMessageWithoutPasswordPOM(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Marts", "");
        String actualText = loginPage.getErrorMessageTextField().getText();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualText,expectedErrorMessage);
    }

    @Test
    public void testErrorMessageWithoutUsernameWPOM(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "parole");
        String actualText = loginPage.getErrorMessageTextField().getText();
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(actualText,expectedErrorMessage);
    }

    @Test
    public void testSuccessLogin(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.getPageTitle().getText(),"PRODUCTS");

    }

    @Test
    public void testFooterCopyRightText() {
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Footer footer = new Footer(driver);
        String actualString = footer.getCopyRightTextField().getText();
        String expectedString = "© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
        Assert.assertEquals(actualString, expectedString);
    }


    //////////////////////////////////////////////////////////////////////////////////
    @Test
    public void testSuccessfullLogin() throws InterruptedException {
        driver.get(SWAGLABS_URL);

        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("standard_user");

        WebElement userPassInputField = driver.findElement(By.id("password"));
        userPassInputField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
        loginButton.click();

        WebElement titleText = driver.findElement(By.cssSelector("span[class=title]"));
        titleText.getText();
        Assert.assertEquals(titleText.getText(),"PRODUCTS");

        WebElement linkedInLink = driver.findElement(By.linkText("LinkedIn"));
//      WebElement linkedInLink = driver.findElement(By.linkText("li[class='social_linkedin'] > a"));
//      linkedInLink.click();

        Select sortDropDown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropDown.selectByValue("hilo");

        WebElement addFleeceJacketToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
        addFleeceJacketToCartButton.click();

        Thread.sleep(5000);
    }

    @Test
    public void testSamplePage() throws InterruptedException {
        driver.get(LOCAL_URL);
        WebElement vards = driver.findElement(By.id("fNameID"));
        vards.sendKeys("Marts");
        WebElement uzvards = driver.findElement(By.id("lNameID"));
        uzvards.sendKeys("Tīrums");
        WebElement informacija = driver.findElement(By.name("description"));
        informacija.clear();
        informacija.sendKeys("Šī ir info par mani");
        WebElement checkbox = driver.findElement(By.id("studentID"));
        checkbox.click();
        WebElement radioButtonJava = driver.findElement(By.id("javaID"));
        System.out.println(radioButtonJava.isSelected());
        radioButtonJava.click();
        System.out.println(radioButtonJava.isSelected());

        Select milakaKrasaDropdown = new Select(driver.findElement(By.id("colorsID")));
        milakaKrasaDropdown.selectByIndex(0);
        milakaKrasaDropdown.selectByIndex(1);

        List<WebElement> saraksts = milakaKrasaDropdown.getOptions();
        for (int i = 0; i < saraksts.size(); i++) {
            System.out.println(saraksts.get(i).getText());

        }


        Thread.sleep(5000);

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();

    }


}
