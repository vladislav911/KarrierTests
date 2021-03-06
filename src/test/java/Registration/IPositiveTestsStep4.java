package Registration;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;

public class IPositiveTestsStep4 extends TestDataBaseRegistration {
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
        ClickOnButtonRegistrationStep4();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertNotEquals(Url1, Url2);
        UrlPageStep5 = driver.getCurrentUrl();
    }
}