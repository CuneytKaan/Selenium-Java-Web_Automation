import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();  // creating Chrome Driver
        driver.manage().window().maximize();    // Maximizing the browser window
        driver.get("https://www.gittigidiyor.com/");    // Sending web-address to the driver
    }

    @Test
    public void allTests() throws InterruptedException {    // Running all defined tests
        test_mainPage mainPage = new test_mainPage(driver);
        test_mainPage.testCheck();

        test_logInPage logInPage = new test_logInPage(driver);
        test_logInPage.login();

        test_searchPage searchPage = new test_searchPage(driver);
        test_searchPage.testSearch();
    }

    @After
    public void TearDown(){
        driver.quit();
    }
}

