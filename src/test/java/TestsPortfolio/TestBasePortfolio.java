package TestsPortfolio;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class TestBasePortfolio {

    static protected WebDriver driver;
    static protected String baseUrl;
    static protected String Email;
    static protected String Picture1;
    static protected String Picture2;
    static protected String Picture3;
    protected StringBuffer verificationErrors = new StringBuffer();
    private boolean acceptNextAlert = true;


    @BeforeTest
    public void setUp() throws Exception {
        //System.setProperty("webdriver.opera.driver", "D:\\selenium\\operadriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "http://dev.karrierestart.no";
        Email = "testdy28@mail.ru";
        Picture1 = "file://C:/Users\\Vlad\\Desktop\\картинки\\1.jpg";
        Picture2 = "file://C:/Users\\Vlad\\Desktop\\картинки\\2.jpg";
        Picture3 = "file://C:/Users\\Vlad\\Desktop\\картинки\\3.jpg";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1285, 985));
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    // General methods
    public void refreshPage () throws  InterruptedException{
        driver.navigate().refresh();
        Thread.sleep(1000);
    }

    public void scrollPageUp () {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.head.scrollHeight)");
    }

    public void assertElementNotPresent(By by) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(0, driver.findElements(by).size());
    }

    public void waitForElementPresent(By by) throws InterruptedException {
        for (int second = 0;; second++) {
            if (second >= 30) fail("timeout");
            try { if (isElementPresent(by)) break; } catch (Exception e) {}
            Thread.sleep(1500);
        }
    }


    public void waitForTitle(String by) throws InterruptedException {
        for (int second = 0; ; second++) {
            if (second >= 30) fail("timeout");
            try {
                if (by.equals(driver.getTitle())) break;
            } catch (Exception e) {
            }
            Thread.sleep(1500);
        }
    }

    public void loggIn() throws Exception {
        // Open BaseUrl
        driver.get(baseUrl);
        // Login User Test1
        driver.findElement(By.id("nav-login")).click();
        driver.findElement(By.id("UserName")).clear();
        driver.findElement(By.id("UserName")).sendKeys(Email);
        driver.findElement(By.id("LoginPassword")).clear();
        driver.findElement(By.id("LoginPassword")).sendKeys("test");
        driver.findElement(By.className("login-btn")).click();
        Thread.sleep(5000);
        // Verify name user - Test2 User2
        //assertEquals(driver.findElement(By.cssSelector("span.li-txt.overflow-ellipsis")).getText(), "Min side");
    }

    public void closeReklam() throws Exception {
        driver.findElement(By.xpath("//*[@id='staticad']/div/div[1]")).click();
    }

    public void goToPageProfil() throws Exception {
        driver.get(baseUrl + "/karriereprofil?id=105371");
        waitForElementPresent(By.xpath("//*[@id='main-story']/a"));
    }

    public void goToPagePortfolio() throws Exception {
        //goToPageProfil();
        //driver.findElement(By.xpath("(//a[contains(text(),'Portefølje')])[2]")).click();
        //waitForElementPresent(By.xpath("//*[@id='project-add']/i"));
        driver.get(baseUrl + "/karriereprofil?id=105371#p-portfolio");
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='project-add']/i")));
    }

    public void goToPagePortfolioProject() throws Exception {
        goToPageProfil();
        driver.findElement(By.xpath("(//a[contains(text(),'Portefølje')])[2]")).click();
        WebDriverWait wait19 = new WebDriverWait(driver, 30);
        wait19.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='project-view']/div[1]/div")));
        Thread.sleep(1000);
    }

    public void clickButtonAddProsjekt() throws Exception {
        driver.findElement(By.xpath("//a[@id='project-add']/i")).click();
        waitForElementPresent(By.id("Name"));
        Thread.sleep(1000);
    }

    public void backFromProsjektToPortfolio() throws Exception {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='CandidateProfileHeader']/div/div[2]/div[2]")));
        driver.findElement(By.linkText("Lukk og forhåndsvis")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Tilbake til prosjekter")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='CandidateProfileHeader']/div/div[2]/div[2]")));
        driver.findElement(By.linkText("Tilbake til prosjekter")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("project-add")));
        Thread.sleep(1000);
    }

    public void clickButtonLagre() {
        driver.findElement(By.xpath("//div[@id='projectEdit_cnt']/div/div[3]/div/button")).click();
    }


}



