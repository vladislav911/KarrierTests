package Registration;
import org.omg.CORBA.Current;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Tests7PositiveTestsStep3 extends TestDataBase {
    @Test(priority = 1)
    public void CorrectTypePageStep3() throws Exception {
        // Go to Page Step3
        driver.get(UrlPageStep3);
        // Type Adresse
        driver.findElement(By.id("StreetAddress")).clear();
        driver.findElement(By.id("StreetAddress")).sendKeys("Artema street");
        // Type Postnummer
        driver.findElement(By.id("ZipCode")).clear();
        driver.findElement(By.id("ZipCode")).sendKeys("49121");
        // Type Sted
        driver.findElement(By.id("Location")).clear();
        driver.findElement(By.id("Location")).sendKeys("Dnepropetrovsk");
        // Type Mobiltelefon
        driver.findElement(By.id("CellPhone")).clear();
        driver.findElement(By.className("selected-flag")).click();
        driver.findElement(By.cssSelector(".iti-flag.ua")).click();
        driver.findElement(By.id("StreetAddress")).click();
        driver.findElement(By.id("CellPhone")).sendKeys("961337281");
        driver.findElement(By.id("StreetAddress")).click();
        // Chose Land
        driver.findElement(By.id("Country_chosen")).click();
        driver.findElement(By.xpath("//*[@id='Country_chosen']/div/div/input")).sendKeys("Ukraina");
        driver.findElement(By.xpath("//*[@id='Country_chosen']/div/ul/li/em")).click();
        driver.findElement(By.id("StreetAddress")).click();
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        driver.findElement(By.xpath("//button[@onclick=\"$('#registration_form').submit();\"]")).click();
        // Verify text Litt om dine jobbønsker
        try {
            assertEquals(driver.findElement(By.cssSelector("h1.sh-main-txt")).getText(), "Litt om dine jobbønsker");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=!Url2
        Assert.assertNotEquals(Url1, Url2);
        UrlPageStep4 = driver.getCurrentUrl();
    }
}


