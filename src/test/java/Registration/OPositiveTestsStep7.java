package Registration;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;

public class OPositiveTestsStep7 extends TestDataBaseRegistration {
    @Test(priority = 1)
    public void CorrectTypePageStep7() throws Exception {
        // Go to Page Step7
        driver.get(UrlPageStep7);
        // Chose City
        driver.findElement(By.xpath("//*[@id='bi-cat-main']/div[1]")).click();
        Thread.sleep(1000);
        // Scroll page up
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
        // Get current Url1
        String Url1 = driver.getCurrentUrl();
        // Click button Registration
        ClickOnButtonRegistrationStep7();
        String Url2 = driver.getCurrentUrl();
        // Verify Url1=Url2
        Assert.assertNotEquals(Url1, Url2);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.sign-up-wrapper > div > div > div > div > h3")).getText(), "Bekreft din e-postadresse");
    }

   @Test(priority = 2)
    public void VerifyActivationAccTestUser() throws Exception {
       // Go to Page ActivationAccount
       driver.get(baseUrl + "/Account/GetActivationLink?email=" + Email1);
       String stringFromPage = driver.findElement(By.cssSelector("pre")).getText();
       StringBuilder sb = new StringBuilder(stringFromPage);
       sb.deleteCharAt(sb.length()-1);
       sb.deleteCharAt( 0 );
       String LinkConfirtm = sb.toString();
       // Go to LinkConfirm
       driver.get(LinkConfirtm);
       try {
           assertEquals(driver.findElement(By.cssSelector("strong")).getText(), "Velkommen til din personlige startside for jobb og karriere!");
       } catch (Error e) {
           verificationErrors.append(e.toString());
       }
       try {
           assertEquals(driver.findElement(By.cssSelector("span.li-txt.overflow-ellipsis")).getText(), "Min side");
       } catch (Error e) {
           verificationErrors.append(e.toString());
       }
       Thread.sleep(2000);
       driver.findElement(By.cssSelector(".drop-down-ctrl")).click();
       driver.findElement(By.linkText("Logg ut")).click();
       String Url = driver.getCurrentUrl();
       Assert.assertEquals(Url,baseUrl + "/");
   }
}

