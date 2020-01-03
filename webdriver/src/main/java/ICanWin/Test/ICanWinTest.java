package ICanWin.Test;

import ICanWin.Pages.PastebinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ICanWinTest {

    private WebDriver driver;

    @BeforeTest
    public void chromeDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testICanWin() {

        String code = "Hello from WebDriver";
        String time = "10 Minutes";
        String name = "helloweb";

        new PastebinPage(driver).openPage().pastebinPage(code, time, name);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
