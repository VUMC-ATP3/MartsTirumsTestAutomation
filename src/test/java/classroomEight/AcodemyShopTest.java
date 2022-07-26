package classroomEight;

import acodemyShop.MainPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcodemyShopTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setupBrowser() throws MalformedURLException {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        driver = new WebDriver(
//                new URL("https://oauth-tiirums-19d0b:430f28c2-fca5-4ff5-aa9e-e12ae04c34bf@ondemand.eu-central-1.saucelabs.com:443/wd/hub"));
//        SafariOptions browserOptions = new SafariOptions();
//        browserOptions.setCapability("platformName", "macOS 12");
//        browserOptions.setCapability("browserVersion", "15");
//        Map<String, Object> sauceOptions = new HashMap<>();
//        sauceOptions.put("build", "<your build id>");
//        sauceOptions.put("name", "<your test name>");
//        browserOptions.setCapability("sauce:options", sauceOptions);
//
//        URL url = new URL("http://192.168.0.105:4444");
//        RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);

        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://192.168.0.105:4444"), chromeOptions);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        EdgeOptions browserOptions = new EdgeOptions();
//        browserOptions.setCapability("platformName", "Windows 11");
//        browserOptions.setCapability("browserVersion", "latest");
//        Map<String, Object> sauceOptions = new HashMap<>();
//        sauceOptions.put("screenResolution", "2560x1600");
//        sauceOptions.put("build", "<Marts build id>");
//        sauceOptions.put("name", "<Revision of remote webdriver>");
//        browserOptions.setCapability("sauce:options", sauceOptions);
//
//        URL url = new URL("https://oauth-tiirums-19d0b:430f28c2-fca5-4ff5-aa9e-e12ae04c34bf@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//        RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);



    }

    @Test
    public void testSearch() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");
        MainPage mainPage = new MainPage(driver);
//        mainPage.getSearchInputField().sendKeys("Beanie");
//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.ENTER).perform();
        mainPage.searchProduct("Beanie");
        Assert.assertEquals(mainPage.getSearchResultText(),"Showing all 2 results");
//        mainPage.getSearchInputField().clear();
//        mainPage.getSearchInputField().sendKeys("tshirt");
//        actions.sendKeys(Keys.ENTER).perform();
//        mainPage.searchProduct("tshirt");
        mainPage.searchProduct("T-shirt");
        Assert.assertEquals(mainPage.getSearchResultText(),"Showing all 3 results");

        mainPage.searchProduct("Hoodie");
        Assert.assertEquals(mainPage.getSearchResults().size(),3);

        List<WebElement> results = mainPage.getSearchResults();
        for (int i = 0; i < results.size(); i++) {
            System.out.println("######################");
            System.out.println(results.get(i).findElement(By.cssSelector("span.woocommerce-Price-amount")).getText());
        }




        Thread.sleep(5000);
    }

    @Test
    public void testSwitchTabs() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");
        System.out.println("Tabu skaits:" + driver.getWindowHandles().size());

        driver.findElement(By.cssSelector("div[class='site-info'] a")).click();
        System.out.println(driver.getTitle());
        System.out.println("Tabu skaits:" + driver.getWindowHandles().size());

        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(tabs.get(1));

        Thread.sleep(3000);
    }

    @Test
    public void testJavascript() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("alert('JURIS JURIS')");
        Thread.sleep(1000);
//
//        WebElement element = driver.findElement(By.cssSelector("li.post-18"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    } //SCROLL EXAPLE

    @Test
    public void mouseActionTest() throws InterruptedException {
        driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");
        driver.findElement(By.id("accept-choices")).click();
        Actions actions = new Actions(driver);
        WebElement hoverMeButton = driver.findElement(By.xpath("//button[text()='Hover Me']"));
        actions.moveToElement(hoverMeButton).perform();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Link 1")).click();
        Thread.sleep(3000);
    }

    @Test
    public void keyBoardActionTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/webdriver/actions_api/keyboard/");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("k").perform();
        Thread.sleep(3000);
    }



    @AfterMethod
    public void tearDownBrowser(){
        driver.quit();
    }




}
