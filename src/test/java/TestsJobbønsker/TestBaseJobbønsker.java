package TestsJobbønsker;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class TestBaseJobbønsker {

    static protected WebDriver driver;
    static protected String baseUrl;
    static protected String Email1;
    protected StringBuffer verificationErrors = new StringBuffer();
    private boolean acceptNextAlert = true;

    @BeforeTest
    public void setUp() throws Exception {
        //System.setProperty("webdriver.opera.driver", "D:\\selenium\\operadriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "http://dev.karrierestart.no";
        Email1 = "testdk250@mail.ru";
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
    public void refreshPage (){
        driver.navigate().refresh();
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
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(by)) break; } catch (Exception e) {}
            Thread.sleep(100);
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
    public void closeReklam() throws Exception {
        driver.findElement(By.xpath("//*[@id='staticad']/div/div[1]")).click();
    }
    public void loggIn() throws Exception {
        // Open BaseUrl
        driver.get(baseUrl);
        // Login User Test1
        driver.findElement(By.id("nav-login")).click();
        driver.findElement(By.id("UserName")).clear();
        driver.findElement(By.id("UserName")).sendKeys(Email1);
        driver.findElement(By.id("LoginPassword")).clear();
        driver.findElement(By.id("LoginPassword")).sendKeys("test");
        driver.findElement(By.className("login-btn")).click();
        // Verify name user - Test2 User2
        try {
            assertEquals(driver.findElement(By.cssSelector("span.li-txt.overflow-ellipsis")).getText(), "Min side");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    public void deleteUser () {
    // Click menu user
    driver.findElement(By.cssSelector(".drop-down-ctrl")).click();
    // Click link - Innstillinger
    driver.findElement(By.linkText("Innstillinger")).click();
    // Click link - Slett profil og alle data
    driver.findElement(By.linkText("Slett profil og alle data")).click();
    // Click link - slett min konto for alltid
    driver.findElement(By.linkText("slett min konto for alltid")).click();
    // Verify Current page = Base Url
    String Url = driver.getCurrentUrl();
    Assert.assertEquals(Url,baseUrl + "/");
    }

  // METHODS FOR REGISTRATION
    public void clickOnButtonRegistrationStep2() {
        driver.findElement(By.xpath("//button[@onclick=\"$('#registration_form').submit();\"]")).click();
    }
    public void clickOnButtonRegistrationStep3() {
        driver.findElement(By.xpath("//button[@onclick=\"$('#registration_form').submit();\"]")).click();
    }
    public void clickOnButtonRegistrationStep4() {
        driver.findElement(By.xpath("//*[@id='registration_form']/div/div[2]/div[1]/div/div[5]/div/button")).click();
    }


 // METHODS FOR STILLINGSTYPER
    public void goToStillingstyper () throws InterruptedException {
        driver.get(baseUrl + "/JobPreferences/JobType");
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
    }
    public void refreshPageStillingstyper() throws InterruptedException {
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='employment_chosen']/a"));
    }
    public void choseStillingstypeAgent() {
        driver.findElement(By.xpath("//*[@id='employment_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='employment_chosen']/div/ul/li[1]")).click();
    }
    public void choseStillingstypeAnnet() {
        driver.findElement(By.xpath("//*[@id='employment_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='employment_chosen']/div/ul/li[2]")).click();
    }
    public void choseStillingstypeEkstrahjelp() {
        driver.findElement(By.xpath("//*[@id='employment_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='employment_chosen']/div/ul/li[3]")).click();
    }
    public void choseStillingstypeFast() {
        driver.findElement(By.xpath("//*[@id='employment_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='employment_chosen']/div/ul/li[4]")).click();
    }
    public void choseStillingstypeFranchisetaker() {
        driver.findElement(By.xpath("//*[@id='employment_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='employment_chosen']/div/ul/li[5]")).click();
    }
    public void choseStillingstypeFrilans() {
        driver.findElement(By.xpath("//*[@id='employment_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='employment_chosen']/div/ul/li[6]")).click();
    }
    public void choseStillingstypeInternship() {
        driver.findElement(By.xpath("//*[@id='employment_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='employment_chosen']/div/ul/li[7]")).click();
    }
    public void choseStillingstypeLærling() {
        driver.findElement(By.xpath("//*[@id='employment_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='employment_chosen']/div/ul/li[8]")).click();
    }
    public void choseStillingstypeProsjekt() {
        driver.findElement(By.xpath("//*[@id='employment_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='employment_chosen']/div/ul/li[9]")).click();
    }
    public void choseStillingstypeSommerjobb() {
        driver.findElement(By.xpath("//*[@id='employment_chosen']/a")).click();
        driver.findElement(By.xpath("//div[@id='employment_chosen']/div/ul/li[10]")).click();
    }
    public void choseOmfangHeltid() {
        driver.findElement(By.xpath("//*[@id='worktime_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='worktime_chosen']/div/ul/li[2]")).click();
    }
    public void choseOmfangDeltid() {
        driver.findElement(By.xpath("//*[@id='worktime_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='worktime_chosen']/div/ul/li[1]")).click();
    }
    public void choseOmfangHeltidDeltid() {
        driver.findElement(By.xpath("//*[@id='worktime_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='worktime_chosen']/div/ul/li[3]")).click();
    }

    // METHODS FOR FAGOMRADER
    public void goToFagområder () throws InterruptedException {
        driver.get(baseUrl + "/JobPreferences/ProfessionCategory");
        waitForElementPresent(By.xpath("//*[@id='ProfessionCategory_chosen']/a"));
    }
    public void refreshPageFagområder() throws InterruptedException {
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='ProfessionCategory_chosen']/a"));
    }
    public void choseFagområdeFirstPositionItem() {
        driver.findElement(By.xpath("//*[@id='ProfessionCategory_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='ProfessionCategory_chosen']/div/ul/li[1]")).click();
    }

    // METHODS FOR YRKER
    public void goToYrker () throws InterruptedException {
        driver.get(baseUrl + "/JobPreferences/Professions");
        waitForElementPresent(By.xpath("//*[@id='ProfessionCategory_chosen']/a"));
    }
    public void refreshPageYrker() throws InterruptedException {
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='ProfessionCategory_chosen']/a"));
    }
    public void choseKategoriEstetiske() {
        driver.findElement(By.xpath("//*[@id='ProfessionCategory_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='ProfessionCategory_chosen']/div/ul/li[1]")).click();
    }
    public void choseKategoriJus() {
        driver.findElement(By.xpath("//*[@id='ProfessionCategory_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='ProfessionCategory_chosen']/div/ul/li[7]")).click();
    }
    public void choseYrkeAdvokat() {
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/div/ul/li[6]")).click();
    }
    public void choseYrkeAnimator() {
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/div/ul/li[4]")).click();
    }
    public void choseYrkeAdvokatfullmektig() {
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/div/ul/li[2]")).click();
    }
    public void choseYrkeDommer() {
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/div/ul/li[4]")).click();
    }
    public void choseYrkeEtterforsker() {
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/div/ul/li[6]")).click();
    }
    public void choseYrkeDomstolsjurist() {
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/div/ul/li[5]")).click();
    }
    public void choseYrkeJurist() {
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/div/ul/li[9]")).click();
    }
    public void choseYrkeDommerfullmektig() {
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/div/ul/li[4]")).click();
    }
    public void choseYrkeAdvokatsekretær() {
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='ProfessionId_chosen']/div/ul/li[2]")).click();
    }
    // METHODS FOR BRANSJER
    public void goToBransjer () throws InterruptedException {
        driver.get(baseUrl + "/JobPreferences/Industries");
        waitForElementPresent(By.xpath("//*[@id='IndustryId_chosen']/a"));
    }

    public void refreshPageBransjer() throws InterruptedException {
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='IndustryId_chosen']/a"));
    }
    public void choseBransjeFirstPositionItem() {
        driver.findElement(By.xpath("//*[@id='IndustryId_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='IndustryId_chosen']/div/ul/li[1]")).click();
    }

    // METHODS FOR ARBEIDSGIVERE(Firmanavn)

    public void goToArbeidsgivere () throws InterruptedException {
        driver.get(baseUrl + "/JobPreferences/Companies");
        waitForElementPresent(By.id("CompanyName"));
    }
    public void refreshPageArbeidsgivere() throws InterruptedException {
        refreshPage();
        waitForElementPresent(By.id("CompanyName"));
    }

    // METHODS FOR ARBEIDSGIVERE(Bransje)

    public void goToArbeidsgivereBransje () throws InterruptedException {
        driver.get(baseUrl + "/JobPreferences/Companies");
        waitForElementPresent(By.xpath("//*[@id='CompanyForm']/div/div[1]/div[2]"));
        driver.findElement(By.xpath("//*[@id='CompanyForm']/div/div[1]/div[2]")).click();
        waitForElementPresent(By.xpath("//*[@id='industry_select_chosen']/a"));
    }
    public void refreshPageArbeidsgivereBransje() throws InterruptedException {
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='CompanyForm']/div/div[1]/div[2]"));
        driver.findElement(By.xpath("//*[@id='CompanyForm']/div/div[1]/div[2]")).click();
        waitForElementPresent(By.xpath("//*[@id='industry_select_chosen']/a"));
    }
    public void choseBransjeAdvokat() {
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/div/ul/li[1]")).click();
    }
    public void choseBransjeBankvirksomhet() {
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/div/ul/li[2]")).click();
    }
    public void choseBransjeEiendom() {
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/div/ul/li[4]")).click();
    }
    public void choseBransjeEngineering() {
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/div/ul/li[5]")).click();
    }
    public void choseBransjeFarmasi() {
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/div/ul/li[6]")).click();
    }
    public void choseBransjeFinans() {
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/div/ul/li[7]")).click();
    }
    public void choseBransjeForsikring() {
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/div/ul/li[8]")).click();
    }
    public void choseBransjeForsikringOg() {
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/div/ul/li[9]")).click();
    }
    public void choseBransjeHelse() {
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='industry_select_chosen']/div/ul/li[10]")).click();
    }

    public void choseFirmaAdvokatfirmaetCLP() {
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/div/ul/li[2]")).click();
    }
    public void choseFirmaABNAmro() {
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/div/ul/li[2]")).click();
    }
    public void choseFirmaABBL() {
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/div/ul/li[2]")).click();
    }
    public void choseFirmaBS() {
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/div/ul/li[2]")).click();
    }
    public void choseFirmaGE() {
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/div/ul/li[2]")).click();
    }
    public void choseFirmaABG() {
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/div/ul/li[2]")).click();
    }
    public void choseFirmaAGIOS() {
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/div/ul/li[2]")).click();
    }
    public void choseFirmaABB() {
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/div/ul/li[2]")).click();
    }
    public void choseFirmaBeauty() {
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='company_select_chosen']/div/ul/li[2]")).click();
    }


    // METHODS FOR ARBEIDSSTEDER

    public void goToArbeidssteder () throws InterruptedException {
        driver.get(baseUrl + "/JobPreferences/Locations");
        waitForElementPresent(By.xpath("//*[@id='sLocation_chosen']/a"));
    }
    public void refreshPageArbeidssteder() throws InterruptedException {
        refreshPage();
        waitForElementPresent(By.xpath("//*[@id='sLocation_chosen']/a"));
    }
    public void choseStedThirdPositionItem() {
        driver.findElement(By.xpath("//*[@id='sLocation_chosen']/a")).click();
        driver.findElement(By.xpath("//*[@id='sLocation_chosen']/div/ul/li[3]")).click();
    }
}

