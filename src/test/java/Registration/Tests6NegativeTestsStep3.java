package Registration;
import org.omg.CORBA.Current;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Tests6NegativeTestsStep3 extends TestDataBase {

    @Test(priority = 1)
    public void TryToRegistrationWithoutSted() throws Exception {
        // Go to Page Step3
        driver.get(UrlPageStep3);
        // Type Adresse
        driver.findElement(By.id("StreetAddress")).clear();
        driver.findElement(By.id("StreetAddress")).sendKeys("Artema street");
        // Type Postnummer
        driver.findElement(By.id("ZipCode")).clear();
        driver.findElement(By.id("ZipCode")).sendKeys("49121");
        driver.findElement(By.id("CellPhone")).click();
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        driver.findElement(By.xpath("//button[@onclick=\"$('#registration_form').submit();\"]")).click();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }

    @Test(priority = 2)
    public void TryToRegistrationWithoutPostnummer() throws Exception {
        // Type Sted
        driver.findElement(By.id("Location")).clear();
        driver.findElement(By.id("Location")).sendKeys("Dnepropetrovsk");
        // Clear Postnummer
        driver.findElement(By.id("ZipCode")).clear();
        driver.findElement(By.id("CellPhone")).click();
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        driver.findElement(By.xpath("//button[@onclick=\"$('#registration_form').submit();\"]")).click();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }
    @Test(priority = 3)
    public void TryToRegistrationWithoutAdresse () throws Exception {
        // Type Postnummer
        driver.findElement(By.id("ZipCode")).clear();
        driver.findElement(By.id("ZipCode")).sendKeys("49121");
        // Clear Adresse
        driver.findElement(By.id("StreetAddress")).clear();
        driver.findElement(By.id("CellPhone")).click();
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        driver.findElement(By.xpath("//button[@onclick=\"$('#registration_form').submit();\"]")).click();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }
    @Test(priority = 4)
    public void PhoneWithLetter () throws Exception {
        // Type Adresse
        driver.findElement(By.id("StreetAddress")).clear();
        driver.findElement(By.id("StreetAddress")).sendKeys("Artema street");
        // Type phone
        driver.findElement(By.id("CellPhone")).clear();
        driver.findElement(By.id("CellPhone")).sendKeys("asd");
        driver.findElement(By.id("StreetAddress")).click();
        // Verify text "Verifiser"
        Assert.assertTrue(isElementPresent(By.linkText("Verifiser")));
    }
    @Test(priority = 5)
    public void IncorrectPhone () throws Exception {
        // Type phone;
        driver.findElement(By.id("CellPhone")).sendKeys("1122332233233215");
        driver.findElement(By.id("StreetAddress")).click();
        // Verify text "Ugyldig telefonnummer"
        Assert.assertEquals(driver.findElement(By.id("CellPhone-error")).getText(), "Ugyldig telefonnummer");
    }
    @Test(priority = 6)
    public void LongPhone () throws Exception {
        // Type phone
        driver.findElement(By.id("CellPhone")).clear();
        driver.findElement(By.id("CellPhone")).sendKeys("1122332233233215232323232");
        driver.findElement(By.id("StreetAddress")).click();
        // Verify text "CellPhone maksimal lengde er 20"
        Assert.assertEquals(driver.findElement(By.id("CellPhone-error")).getText(), "CellPhone maksimal lengde er 20");
    }
    @Test(priority = 7)
    public void CorrectPhone () throws Exception {
        // Type correct phone
        driver.findElement(By.id("CellPhone")).clear();
        driver.findElement(By.className("selected-flag")).click();
        driver.findElement(By.cssSelector(".iti-flag.ua")).click();
        driver.findElement(By.id("StreetAddress")).click();
        driver.findElement(By.id("CellPhone")).sendKeys("961337281");
        driver.findElement(By.id("StreetAddress")).click();
        // Verify text "Ikke verifisert"
        Assert.assertEquals(driver.findElement(By.className("yellow-btn")).getText(), "Ikke verifisert");
    }

}
