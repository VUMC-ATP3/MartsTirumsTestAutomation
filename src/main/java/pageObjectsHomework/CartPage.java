package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    public WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    private By testOnesieInCart = By.xpath("//*[@id=\"item_2_title_link\"]/div");
    public WebElement getTestOnesieInCart(){
        return driver.findElement(testOnesieInCart);
    }

    private By checkoutButton = By.id("checkout");
    public WebElement getCheckoutButton(){
        return driver.findElement(checkoutButton);
    }



}
