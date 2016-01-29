package Registration;
import org.omg.CORBA.Current;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class PRegistrationUserWithStatusNotLookingWork extends TestDataBase {
    @Test(priority = 1)
    public void RegistrationUser() throws Exception {
        // Step1
        // Go to http://karrierestart.no/registrering
        driver.get(baseUrl + "/registrering");
        // Type Email
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(Email2);
        // Type Password
        driver.findElement(By.id("RegistratePassword")).clear();
        driver.findElement(By.id("RegistratePassword")).sendKeys("test");
        // Type ConfirmPassword
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test");
        // Click checkbox
        driver.findElement(By.className("checkbox-label")).click();
        // click Registration button
        driver.findElement(By.id("submit")).click();
        // Step2
        // Type First Name
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Test2");
        // Type Last Name
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("User2");
        // Chose day
        Select selectByValueDay = new Select(driver.findElement(By.className("day")));
        selectByValueDay.selectByVisibleText("07");
        // Chose month
        Select selectByValueMonth = new Select(driver.findElement(By.className("month")));
        selectByValueMonth.selectByVisibleText("jun");
        // Chose year
        Select selectByValueYear = new Select(driver.findElement(By.className("year")));
        selectByValueYear.selectByVisibleText("1989");
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Сhose gender
        driver.findElement(By.id("male")).click();
        // Click button Registration
        ClickOnButtonRegistrationStep2();
        // Step3
        // Type Adresse
        driver.findElement(By.id("StreetAddress")).clear();
        driver.findElement(By.id("StreetAddress")).sendKeys("Gagarina street");
        // Type Postnummer
        driver.findElement(By.id("ZipCode")).clear();
        driver.findElement(By.id("ZipCode")).sendKeys("42121");
        // Type Sted
        driver.findElement(By.id("Location")).clear();
        driver.findElement(By.id("Location")).sendKeys("Kiev");
        // Type Mobiltelefon
        driver.findElement(By.id("CellPhone")).clear();
        driver.findElement(By.className("selected-flag")).click();
        driver.findElement(By.cssSelector(".iti-flag.ua")).click();
        driver.findElement(By.id("StreetAddress")).click();
        driver.findElement(By.id("CellPhone")).sendKeys("938872305");
        driver.findElement(By.id("StreetAddress")).click();
        // Chose Land
        driver.findElement(By.id("Country_chosen")).click();
        driver.findElement(By.xpath("//*[@id='Country_chosen']/div/div/input")).sendKeys("Ukraina");
        driver.findElement(By.xpath("//*[@id='Country_chosen']/div/ul/li/em")).click();
        driver.findElement(By.id("StreetAddress")).click();
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        ClickOnButtonRegistrationStep3();
        // Step4
        // Chose status
        driver.findElement(By.id("Status_chosen")).click();
        driver.findElement(By.xpath("//*[@id='Status_chosen']/div/div/input")).sendKeys("Jeg søker ikke etter jobb");
        driver.findElement(By.xpath("//*[@id='Status_chosen']/div/ul/li/em")).click();
        // Click button Registration
        ClickOnButtonRegistrationStep4();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.sign-up-wrapper > div > div > div > div > h3")).getText(), "Bekreft din e-postadresse");
    }
}
