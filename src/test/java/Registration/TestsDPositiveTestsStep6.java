package Registration;
        import org.omg.CORBA.Current;
        import org.openqa.selenium.support.ui.Select;
        import org.testng.Assert;
        import org.testng.annotations.*;
        import static org.testng.Assert.*;
        import org.openqa.selenium.*;
        import org.openqa.selenium.By;
        import org.openqa.selenium.support.ui.Select;

public class TestsDPositiveTestsStep6 extends TestDataBase {
    @Test(priority = 1)
    public void CorrectTypePageStep6() throws Exception {
        // Go to Page Step6
        driver.get(UrlPageStep6);
        // Chose Proffesion
        driver.findElement(By.xpath("//*[@id='bi-cat-main']/div[1]")).click();
        Thread.sleep(1000);
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        ClickOnButtonRegistrationStep6();
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertNotEquals(Url1, Url2);
        UrlPageStep7 = driver.getCurrentUrl();
    }
}
