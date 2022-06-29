import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver chromParluks;

    @Test
    public void testPageTitle(){
        chromParluks = new ChromeDriver(); //atver pārlūkprogrammu
        chromParluks.navigate().to("http://www.lu.lv/");
        chromParluks.manage().window().maximize();
        String expectedTitle = "Latvijas Universitāte";
        String actualTitle = chromParluks.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        chromParluks.quit();
    }

    @AfterMethod
    public void closeBrowser(){
        chromParluks.quit();
    }
    //gfhgfj
}
