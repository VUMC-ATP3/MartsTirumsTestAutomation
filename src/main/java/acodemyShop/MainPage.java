package acodemyShop;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchInputField = By.id("woocommerce-product-search-field-0");
    private By resultCountLabel = By.cssSelector("header[class='woocommerce-products-header']+div[class='storefront-sorting'] p");

    private By searchResults = By.cssSelector("li[class*='product']");

    public List<WebElement> getSearchResults(){
        return driver.findElements(searchResults);
    }

    public String getSearchResultText(){
        return driver.findElement(resultCountLabel).getText();
    }

    public WebElement getSearchInputField(){
        return driver.findElement(searchInputField);
    }

    public void searchProduct(String searchQuery){
        getSearchInputField().clear();
        getSearchInputField().sendKeys(searchQuery);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }


}
