package BringItOn.Test;

import BringItOn.Pages.PastebinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BringItOnTest {

    private WebDriver driver;

    private String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private String syntax = "Bash";
    private String time = "10 Minutes";
    private String name = "how to gain dominance among developers";


    @BeforeTest
    public void chromeDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testBringItOn() {
        new PastebinPage(driver).openPage().pastebinPage(code, syntax, time, name);
    }

    @Test
    public void testCheckPastebinPage() {
        new PastebinPage(driver).getBrowserPageTitle().getText().contentEquals(name);
        new PastebinPage(driver).getSyntaxIsHighlighted().getText().contentEquals(syntax);
        new PastebinPage(driver).getEnterCode().getText().contentEquals(code);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
