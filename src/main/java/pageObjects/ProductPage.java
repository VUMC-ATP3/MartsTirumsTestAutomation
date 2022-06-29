package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    public WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private By pageTitle = By.cssSelector("span[class='title']");

    public WebElement getPageTitle(){
        return driver.findElement(pageTitle);
    }


}
