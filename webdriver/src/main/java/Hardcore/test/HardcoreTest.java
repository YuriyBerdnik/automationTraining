package Hardcore.test;

import Hardcore.pages.CalculatorPage;
import Hardcore.pages.MailPage;
import Hardcore.pages.NewTempPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class HardcoreTest {

    private WebDriver driver;

    @BeforeTest
    public void choromeDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //    @Test(priority = 1)
//    public void testGoToCalculator() {
//        new CloudGooglePage(driver).openPage().goToCalculator();
//    }

    @Test(priority = 2)
    public void testFillInTheForm() {
        new CalculatorPage(driver).openPage().fillInTheForm("4", "");
    }

//    @Test(priority = 3)
//    public void testCheckDataConsistency() {
//        new CalculatorPage(driver).checkDataConsistency();
//    }

    @Test(priority = 3)
    public void testNewTempEmailPageAndSendEmail() {
        ArrayList<String> tabs = new Pages(driver).openNewPage(new NewTempPage(driver).getPAGE_URL());
        String newEmailAddress = new NewTempPage(driver).getEmailTempAddress();
        new Pages(driver).switchTab(tabs, 0);
        new CalculatorPage(driver).fillInTheFormForSendEmail(newEmailAddress);
    }

//    @AfterTest
//    public void closeBrowser() {
//        driver.quit();
//    }
}
