package Registration;
import org.omg.CORBA.Current;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Tests9PositiveTestsStep4 extends TestDataBase {
    @Test(priority = 1)
    public void CorrectTypePageStep4() throws Exception {
        // Go to Page Step4
        driver.get(UrlPageStep4);
        // Chose Ønsket jobbtype  - Fast ansettelse
        driver.findElement(By.cssSelector("div.empCnt > label.checkbox-label")).click();
        // Chose Ønsket omfang  - Heltid
        driver.findElement(By.cssSelector("label.checkbox-label")).click();
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        driver.findElement(By.xpath("//*[@id='registration_form']/div/div[2]/div[1]/div/div[5]/div/button")).click();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertNotEquals(Url1, Url2);
        UrlPageStep5 = driver.getCurrentUrl();
    }
}