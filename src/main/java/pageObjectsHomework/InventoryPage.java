package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

    public WebDriver driver;
    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    private By productTitle = By.cssSelector("span[class='title']");
    public WebElement getProductTitle(){
        return driver.findElement(productTitle);
    }

    private By productOnesie = By.id("add-to-cart-sauce-labs-onesie");

    public WebElement getProductOnesie(){
        return driver.findElement(productOnesie);
    }

    private By cartButton = By.cssSelector("span[class='shopping_cart_badge']");
    public WebElement getCartButton(){
        return driver.findElement(cartButton);
    }

    private By emptyCartbuttom = By.cssSelector("a[class='shopping_cart_link']");
    public WebElement getEmptyCartButton(){
        return driver.findElement(emptyCartbuttom);
    }
    public void addToCart(){
        getProductOnesie().click();
    }




}
