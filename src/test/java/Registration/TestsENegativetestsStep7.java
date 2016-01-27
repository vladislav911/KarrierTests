package Registration;
import org.omg.CORBA.Current;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class TestsENegativeTestsStep7 extends TestDataBase {
    @Test(priority = 1)
    public void TryToRegistrationWithoutCity() throws Exception {
        // Go to Page Step7
        driver.get(UrlPageStep7);
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        driver.findElement(By.xpath("//*[@id='registration_cnt']/div/div[5]/a")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }

    @Test(priority = 2)
    public void TryToRegistrationWithDeleteCity() throws Exception {
        // Chose City
        driver.findElement(By.xpath("//*[@id='bi-cat-main']/div[1]")).click();
        Thread.sleep(1000);
        // Delete proffesion
        driver.findElement(By.xpath("//*[@id='location-list']/ul/li[3]/span/a")).click();
        Thread.sleep(1000);
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        driver.findElement(By.xpath("//*[@id='registration_cnt']/div/div[5]/a")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }
    @Test(priority = 3)
    public void TryToRegistrationWithDoubleClickOnCity() throws Exception {
        // Chose City
        driver.findElement(By.xpath("//*[@id='bi-cat-main']/div[1]")).click();
        Thread.sleep(1000);
        // Delete City
        driver.findElement(By.xpath("//*[@id='bi-cat-main']/div[1]")).click();
        Thread.sleep(1000);
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        driver.findElement(By.xpath("//*[@id='registration_cnt']/div/div[5]/a")).click();
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }
}
