import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class test_mainPage {
    private static WebDriver driver;
    public test_mainPage(WebDriver driver) {
        this.driver=driver;
    }

    public static void testCheck() throws InterruptedException {
        String currentUrl;
        currentUrl = driver.getCurrentUrl();
        // getting the current URL
        Assert.assertEquals("Couldn't enter the website!","https://www.gittigidiyor.com/",currentUrl);
        Thread.sleep(2500);
        // checking if the main page has opened or not
    }
}