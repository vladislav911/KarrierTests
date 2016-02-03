package Registration;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;

public class JNegativeTestsStep5 extends TestDataBaseRegistration {

    @Test(priority = 1)
    public void TryToRegistrationWithoutKjernekompetanse() throws Exception {
        // Go to Page Step5
        driver.get(UrlPageStep5);
        // Chose Utdanningsnivå - Yrkesskole / videregående skole
        driver.findElement(By.id("EducationLevel_chosen")).click();
        driver.findElement(By.xpath("//*[@id='EducationLevel_chosen']/div/div/input")).sendKeys("Yrkesskole / videregående skole");
        driver.findElement(By.xpath("//*[@id='EducationLevel_chosen']/div/ul/li/em")).click();
        // Chose Arbeidserfaring - 1+ - 2 år  arbeidserfaring
        driver.findElement(By.id("CareerLevel_chosen")).click();
        driver.findElement(By.xpath("//*[@id='CareerLevel_chosen']/div/div/input")).sendKeys("1+ - 2 år  arbeidserfaring");
        driver.findElement(By.xpath("//*[@id='CareerLevel_chosen']/div/ul/li/em")).click();
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        ClickOnButtonRegistrationStep5();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }

    @Test(priority = 2)
    public void TryToRegistrationWithoutArbeidserfaring() throws Exception {
        // Clear Arbeidserfaring - 1+ - 2 år  arbeidserfaring
        driver.findElement(By.id("CareerLevel_chosen")).click();
        driver.findElement(By.xpath("//*[@id='CareerLevel_chosen']/div/div/input")).sendKeys("Har du arbeidserfaring?");
        driver.findElement(By.xpath("//*[@id='CareerLevel_chosen']/div/ul/li/em")).click();
        // Chose Kjernekompetanse
        driver.findElement(By.id("CoreCompetence_chosen")).click();
        driver.findElement(By.xpath("//*[@id='CoreCompetence_chosen']/ul/li/input")).sendKeys("Matematikk og naturfag");
        driver.findElement(By.xpath("//*[@id='CoreCompetence_chosen']/div/ul/li/em")).click();
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        ClickOnButtonRegistrationStep5();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }
    @Test(priority = 3)
    public void TryToRegistrationWithoutUtdanningsnivå() throws Exception {
        // Clear Utdanningsnivå - Yrkesskole / videregående skole
        driver.findElement(By.id("EducationLevel_chosen")).click();
        driver.findElement(By.xpath("//*[@id='EducationLevel_chosen']/div/div/input")).sendKeys("Hva er din høyeste utdanning?");
        driver.findElement(By.xpath("//*[@id='EducationLevel_chosen']/div/ul/li/em")).click();
        // Chose Arbeidserfaring - 1+ - 2 år  arbeidserfaring
        driver.findElement(By.id("CareerLevel_chosen")).click();
        driver.findElement(By.xpath("//*[@id='CareerLevel_chosen']/div/div/input")).sendKeys("1+ - 2 år  arbeidserfaring");
        driver.findElement(By.xpath("//*[@id='CareerLevel_chosen']/div/ul/li/em")).click();
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        ClickOnButtonRegistrationStep5();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }
}
