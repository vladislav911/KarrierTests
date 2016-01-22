package Registration;
import org.omg.CORBA.Current;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Tests4NegativeTestsStep2 extends TestDataBase {

    @Test(priority = 1)
    public void TryToRegistrationWithoutGender() throws Exception {
        // Need to delete after add to Registration tests
        driver.get(UrlPageStep2);
        // Type First Name
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Test");
        // Type Last Name
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("User");
        // Chose day
        Select selectByValueDay = new Select(driver.findElement(By.className("day")));
        selectByValueDay.selectByVisibleText("04");
        // Chose month
        Select selectByValueMonth = new Select(driver.findElement(By.className("month")));
        selectByValueMonth.selectByVisibleText("mai");
        // Chose year
        Select selectByValueYear = new Select(driver.findElement(By.className("year")));
        selectByValueYear.selectByVisibleText("1991");
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
    public void TryToRegistrationWithoutYear() throws Exception {
        // Сhose gender
        driver.findElement(By.id("male")).click();
        // Chose year ar
        Select selectByValueYear = new Select(driver.findElement(By.className("year")));
        selectByValueYear.selectByVisibleText("år");
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
    public void TryToRegistrationWithoutMonth() throws Exception {
        // Chose year ar
        Select selectByValueYear = new Select(driver.findElement(By.className("year")));
        selectByValueYear.selectByVisibleText("1991");
        // Chose month
        Select selectByValueMonth = new Select(driver.findElement(By.className("month")));
        selectByValueMonth.selectByVisibleText("måned");
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
    public void TryToRegistrationWithoutDay() throws Exception {
        // Chose month
        Select selectByValueMonth = new Select(driver.findElement(By.className("month")));
        selectByValueMonth.selectByVisibleText("mai");
        // Chose day
        Select selectByValueDay = new Select(driver.findElement(By.className("day")));
        selectByValueDay.selectByVisibleText("dag");
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        driver.findElement(By.xpath("//button[@onclick=\"$('#registration_form').submit();\"]")).click();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }
    @Test(priority = 5)
    public void TryToRegistrationWithoutLastName() throws Exception {
        // Chose day
        Select selectByValueDay = new Select(driver.findElement(By.className("day")));
        selectByValueDay.selectByVisibleText("04");
        // Clear last name field
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("FirstName")).click();
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        driver.findElement(By.xpath("//button[@onclick=\"$('#registration_form').submit();\"]")).click();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }
    @Test(priority = 6)
    public void TryToRegistrationWithoutFirstName() throws Exception {
        // Type Last Name
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("User");
        // Clear First Name field
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("LastName")).click();
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        driver.findElement(By.xpath("//button[@onclick=\"$('#registration_form').submit();\"]")).click();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
    }

}