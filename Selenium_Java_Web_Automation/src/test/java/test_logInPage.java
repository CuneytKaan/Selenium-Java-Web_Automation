
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class test_logInPage {
    private static WebDriver driver;

    public test_logInPage(WebDriver driver) {   this.driver = driver;   }

    public static void login() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div")).click();
        // clicking logIn button in the header
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a/span")).click();
        // clicking logIn button in the pop-up
        Thread.sleep(1000);

        driver.findElement(By.id("L-UserNameField")).sendKeys("cuneytkaanu2@hotmail.com");
        driver.findElement(By.id("L-PasswordField")).sendKeys("AnadoluTat1071");
        driver.findElement(By.id("gg-login-enter")).click();
        Thread.sleep(2000);
        // sending required logIn informations to the box they belong to

        Assert.assertEquals("Couldn't login!",driver.getCurrentUrl(),"https://www.gittigidiyor.com/");
        // checking if the logIn attempt was successful or not
    }



}

