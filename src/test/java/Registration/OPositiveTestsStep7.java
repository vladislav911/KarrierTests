package Registration;
import org.omg.CORBA.Current;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class OPositiveTestsStep7 extends TestDataBase {
    @Test(priority = 1)
    public void CorrectTypePageStep7() throws Exception {
        // Go to Page Step7
        driver.get(UrlPageStep7);
        // Chose City
        driver.findElement(By.xpath("//*[@id='bi-cat-main']/div[1]")).click();
        Thread.sleep(1000);
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        ClickOnButtonRegistrationStep7();
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertNotEquals(Url1, Url2);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.sign-up-wrapper > div > div > div > div > h3")).getText(), "Bekreft din e-postadresse");
    }
}

