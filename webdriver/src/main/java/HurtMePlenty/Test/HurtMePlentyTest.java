package HurtMePlenty.Test;

import HurtMePlenty.Pages.CalculatorPage;
import HurtMePlenty.Pages.CloudGooglePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HurtMePlentyTest {

    private WebDriver driver;

    @BeforeTest
    public void choromeDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testGoToCalculator() {
        new CloudGooglePage(driver).openPage().goToCalculator();
    }

    @Test(priority = 2)
    public void testFillInTheForm() {
        new CalculatorPage(driver).openPage().fillInTheForm("4", "");
    }

    @Test(priority = 3)
    public void testCheckDataConsistency() {
        new CalculatorPage(driver).checkDataConsistency();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
