package Registration;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;

public class HNegativeTestsStep4 extends TestDataBaseRegistration {
    @Test(priority = 1)
    public void TryToRegistrationWithoutOmfang() throws Exception {
        // Go to Page Step4
        driver.get(UrlPageStep4);
        // Chose Ønsket jobbtype  - Fast ansettelse
        driver.findElement(By.cssSelector("div.empCnt > label.checkbox-label")).click();
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        ClickOnButtonRegistrationStep4();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }

    @Test(priority = 2)
    public void TryToRegistrationWithoutJobbtype() throws Exception {
        // Clean Ønsket jobbtype  - Fast ansettelse
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
        Assert.assertEquals(Url1, Url2);
    }
    @Test(priority = 3)
    public void TryToRegistrationWithoutJobbtypeStatusSokkerIkke() throws Exception {
        // Change status (Søker ikke aktivt, men er åpen for henvendelser)
        driver.findElement(By.id("Status_chosen")).click();
        driver.findElement(By.xpath("//*[@id='Status_chosen']/div/div/input")).sendKeys("Søker ikke aktivt, men er åpen for henvendelser");
        driver.findElement(By.xpath("//*[@id='Status_chosen']/div/ul/li/em")).click();
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        ClickOnButtonRegistrationStep4();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);

    }
    @Test(priority = 4)
    public void TryToRegistrationWithoutOmfangStatusSokkerIkke() throws Exception {
        // Clear Ønsket omfang  - Heltid
        driver.findElement(By.cssSelector("label.checkbox-label")).click();
        // Chose Ønsket jobbtype  - Fast ansettelse
        driver.findElement(By.cssSelector("div.empCnt > label.checkbox-label")).click();
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        ClickOnButtonRegistrationStep4();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }
    @Test(priority = 5)
    public void TryToRegistrationWithoutDateStatusErUnder() throws Exception {
        // Chose Ønsket omfang  - Heltid
        driver.findElement(By.cssSelector("label.checkbox-label")).click();
        // Change status (Søker ikke aktivt, men er åpen for henvendelser)
        driver.findElement(By.id("Status_chosen")).click();
        driver.findElement(By.xpath("//*[@id='Status_chosen']/div/div/input")).sendKeys("Er under utdannelse, søker jobb fra…");
        driver.findElement(By.xpath("//*[@id='Status_chosen']/div/ul/li/em")).click();
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        ClickOnButtonRegistrationStep4();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }
    @Test(priority = 6)
    public void TryToRegistrationWithoutOmfangStatusErUnder() throws Exception {
        // Clean Ønsket omfang  - Heltid
        driver.findElement(By.cssSelector("label.checkbox-label")).click();
        // Chose date
        driver.findElement(By.id("StatusDateFrom")).sendKeys("12.12.2015");
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/button[2]")).click();
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        ClickOnButtonRegistrationStep4();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }
    @Test(priority = 7)
    public void TryToRegistrationWithoutJobbtypeStatusErUnder() throws Exception {
        // Chose Ønsket omfang  - Heltid
        driver.findElement(By.cssSelector("label.checkbox-label")).click();
        // Clean Ønsket jobbtype  - Fast ansettelse
        driver.findElement(By.cssSelector("div.empCnt > label.checkbox-label")).click();
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        ClickOnButtonRegistrationStep4();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }

}