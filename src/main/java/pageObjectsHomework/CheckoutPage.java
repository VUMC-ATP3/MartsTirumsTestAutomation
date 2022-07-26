package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckoutPage {
    public WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    private By firstNameField = By.id("first-name");
    private By lasteNameField = By.id("last-name");
    private By zipPostalCodeField = By.id("postal-code");

    private By continueButton = By.id("continue");


    public WebElement getFirstNameField(){
        return driver.findElement(firstNameField);
    }
    public WebElement getLastNameField(){
        return driver.findElement(lasteNameField);
    }
    public WebElement getZipPostalCodeField(){
        return driver.findElement(zipPostalCodeField);
    }

    public void yourInformation(String firstName, String lastName, String zipPostalCode){
        getFirstNameField().sendKeys(firstName);
        getLastNameField().sendKeys(lastName);
        getZipPostalCodeField().sendKeys(zipPostalCode);
    }

    public WebElement getContinueButton(){
        return driver.findElement(continueButton);
    }

    private By errorFirstName = By.cssSelector("h3[data-test='error']");
    //Error: First Name is required
    private By errorLastName = By.cssSelector("h3[data-test='error']");
    //Error: Last Name is required
    private By errorZipPostalCode = By.cssSelector("h3[data-test='error']");
    //Error: Postal Code is required

    private By errorMessage = By.cssSelector("h3[data-test='error']");

    public WebElement getErrorFirstName(){
        return driver.findElement(errorFirstName);
    }
    public WebElement getErrorLastName(){
        return driver.findElement(errorLastName);
    }
    public WebElement getErrorZipPostalCode(){
        return driver.findElement(errorZipPostalCode);
    }
    public WebElement getErrorMessage(){
        return driver.findElement(errorMessage);
    }











}
