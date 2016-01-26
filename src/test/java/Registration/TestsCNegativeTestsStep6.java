package Registration;
import org.omg.CORBA.Current;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class TestsCNegativeTestsStep6 extends TestDataBase {
    @Test(priority = 1)
    public void TryToRegistrationWithout() throws Exception {
        // Go to Page Step6
        driver.get("http://dev.karrierestart.no/CandidateUser/Registration/RegisterStep4?code=4aaaa944-8aa3-446e-89b8-031666426230");
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        driver.findElement(By.xpath("//*[@id='registration_cnt']/ul/div[5]/a")).click();
        // Get current Url2
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertEquals(Url1, Url2);
        UrlPageStep6 = driver.getCurrentUrl();
    }
}
