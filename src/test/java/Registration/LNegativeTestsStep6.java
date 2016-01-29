package Registration;
import org.omg.CORBA.Current;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class LNegativeTestsStep6 extends TestDataBase {
    @Test(priority = 1)
    public void TryToRegistrationWithoutProffesion() throws Exception {
        // Go to Page Step6
        driver.get(UrlPageStep6);
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        ClickOnButtonRegistrationStep6();
        String Url2 = driver.getCurrentUrl();
       // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }

    @Test(priority = 2)
    public void TryToRegistrationWithDeleteProffesion() throws Exception {
        // Chose Proffesion
        driver.findElement(By.xpath("//*[@id='bi-cat-main']/div[1]")).click();
        Thread.sleep(1000);
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Delete proffesion
        driver.findElement(By.xpath("//*[@id='profession-list']/ul/li[3]/span/a")).click();
        Thread.sleep(1000);
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        ClickOnButtonRegistrationStep6();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }
    @Test(priority = 3)
    public void TryToRegistrationWithDoubleClickOnProffesion() throws Exception {
        // Chose Proffesion
        driver.findElement(By.xpath("//*[@id='bi-cat-main']/div[1]")).click();
        Thread.sleep(1000);
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Delete proffesion
        driver.findElement(By.xpath("//*[@id='bi-cat-main']/div[1]")).click();
        Thread.sleep(1000);
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        ClickOnButtonRegistrationStep6();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }
}
