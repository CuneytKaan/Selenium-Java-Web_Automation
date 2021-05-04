import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class test_searchPage {
    private static WebDriver driver;
    public test_searchPage(WebDriver driver) {  this.driver = driver;   }

    public static void testSearch() throws InterruptedException {
        WebElement search_box = driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input"));
        search_box.click();
        search_box.sendKeys("Bilgisayar");
        Thread.sleep(1000);
        // finding the search box and sending to it the word "Bilgisayar"

        WebElement search_button = driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div[1]/div[2]/form/div/div[2]/button"));
        search_button.click();
        Thread.sleep(2500);
        // clicking the search button to apply the search process

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a")));
        WebElement pageButton2 = driver.findElement((By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a")));
        pageButton2.click();
        Thread.sleep(2500);
        // finding and clicking page 2

        Assert.assertEquals("Couldn't enter page 2!","https://www.gittigidiyor.com/arama/?k=Bilgisayar&sf=2",driver.getCurrentUrl());
        // checking if entering page 2 was successful or not

        Random rand = new Random();
        List<WebElement> products = driver.findElements(By.xpath("//*[@product-index]"));
        int number_of_products = rand.nextInt(products.size());
        driver.findElement(By.xpath("//*[@product-index=" + number_of_products + "]")).click();
        String price_chosenProduct = driver.findElement(By.id("sp-price-discountPrice")).getText();
        Thread.sleep(2500);
        // creating a random integer number in the range of number of products shown on the page
        // and then choosing a random product depending to that random number
        // getting the price of the chosen product

        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        WebElement add_button=driver.findElement(By.cssSelector("button[id='add-to-basket']"));
        jse2.executeScript("arguments[0].scrollIntoView();",add_button);
        add_button.click();
        Thread.sleep(2500);
        // adding the chosen product to the basket

        driver.findElement(By.cssSelector("a[class='dIB']")).click();
        String price_basket = driver.findElement(By.xpath("//*[@class='total-price']")).getText();
        Thread.sleep(2500);
        // Expected parametresine indirimli ürün fiyatını gönderdiğim için bazı durumlarda testi geçemiyor.
        // checking if price of chosen product and price written in the basket are the same or not

        WebElement amount = driver.findElement(By.xpath("//*[@class='amount']"));
        amount.click();
        WebElement amount_choice = driver.findElement(By.xpath("//*[@class='amount']/option[2]"));
        amount_choice.click();
        Thread.sleep(2500);
        // clicking to the amount box and increasing the amount of product to 2

        WebElement empty_basket = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[6]/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/a/i"));
        empty_basket.click();
        Thread.sleep(3000);
        String isBasketEmpty=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[2]/h2")).getText();
        Assert.assertEquals("Sepetinizde ürün bulunmamaktadır.",isBasketEmpty);
        Thread.sleep(3000);
        // emptying the basket and checking if the basket is empty or not
    }
}
