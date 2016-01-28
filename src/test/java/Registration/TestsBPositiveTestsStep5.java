package Registration;
import org.omg.CORBA.Current;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class TestsBPositiveTestsStep5 extends TestDataBase {
    @Test(priority = 1)
    public void CorrectTypePageStep5() throws Exception {
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
        Assert.assertNotEquals(Url1, Url2);
        UrlPageStep6 = driver.getCurrentUrl();
    }
}