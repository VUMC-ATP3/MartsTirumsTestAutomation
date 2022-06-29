package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTitle {
    WebDriver chromParluks;

    @Test
    public void testPageTitle(){
        chromParluks.navigate().to("https://www.twitch.tv/");
        chromParluks.manage().window().maximize();
        String expectedTitle = "Twitch";
        String actualTitle = chromParluks.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void testPageTitleTwo(){
        chromParluks.navigate().to("https://isthereanydeal.com/");
        chromParluks.manage().window().maximize();
        String expectedTitle = "Deals - IsThereAnyDeal";
        String actualTitle = chromParluks.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @BeforeMethod
    public void driveris(){
        chromParluks = new ChromeDriver();
    }

    @AfterMethod
    public void closeBrowser(){
        chromParluks.quit();
    }




}
