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
        driver.get(UrlPageStep3);
        driver.findElement(By.id("StreetAddress")).clear();
        driver.findElement(By.id("StreetAddress")).sendKeys("Artema street");
        driver.findElement(By.id("ZipCode")).clear();
        driver.findElement(By.id("ZipCode")).sendKeys("49121");
        driver.findElement(By.xpath("//button[@onclick=\"$('#registration_form').submit();\"]")).click();
    }
}
