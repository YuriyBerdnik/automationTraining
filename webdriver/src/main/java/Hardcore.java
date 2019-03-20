import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Hardcore {
    private WebDriver driver;

    public Hardcore() {
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void testHardcore() {
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();
        new WebDriverWait(driver, 1000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@track-name='exploreProducts']")));
        driver.findElement(By.xpath("//*[@track-name='exploreProducts']")).click();
        new WebDriverWait(driver, 1000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@track-name='seePricing']")));
        driver.findElement(By.xpath("//*[@track-name='seePricing']")).click();
        new WebDriverWait(driver, 1000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@track-name='pricingNav/calculators']")));
        driver.findElement(By.xpath("//*[@track-name='pricingNav/calculators']")).click();

        new WebDriverWait(driver, 1000).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("idIframe")));
        driver.findElement(By.xpath("//md-tab-item/*[@title='Compute Engine']")).click();

        driver.findElement(By.id("input_46")).sendKeys("4");
        driver.findElement(By.id("input_47")).sendKeys("");
        driver.findElement(By.id("select_value_label_40")).click();
        driver.findElement(By.xpath("//*[@id='select_option_48']/*[text()='Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS']")).click();
        driver.findElement(By.id("select_value_label_41")).click();
        driver.findElement(By.xpath("//*[@id='select_option_60']/*[text()='Regular']")).click();
        driver.findElement(By.id("select_value_label_42")).click();
        driver.findElement(By.xpath("//*[@id='select_option_70']/*[contains(text(),'n1-standard-8')]")).click();
        driver.findElement(By.xpath("//md-checkbox[@aria-label='Add GPUs']")).click();
        driver.findElement(By.xpath("//md-select[@placeholder='Number of GPUs']")).click();
        driver.findElement(By.xpath("//*[@id='select_container_330']/md-select-menu//*[@value='1']")).click();
        driver.findElement(By.xpath("//md-select[@placeholder='GPU type']")).click();
        driver.findElement(By.id("select_option_341")).click();
        driver.findElement(By.xpath("//md-select[@placeholder='Local SSD']")).click();
        driver.findElement(By.id("select_option_183")).click();
        driver.findElement(By.xpath("//md-select[@placeholder='Datacenter location']")).click();
        driver.findElement(By.id("select_option_196")).click();
        driver.findElement(By.xpath("//md-select[@placeholder='Committed usage']")).click();
        driver.findElement(By.id("select_option_100")).click();

        driver.findElement(By.xpath("//*[@id='mainForm']//button[text()='Add to Estimate']")).click();
        new WebDriverWait(driver, 1000).until(ExpectedConditions.presenceOfElementLocated(By.id("compute")));

        driver.findElement(By.id("email_quote")).click();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        driver.get("https://10minutemail.com");

        String email = driver.findElement(By.id("mailAddress")).getAttribute("value");

        driver.switchTo().window(tab.get(0));
        new WebDriverWait(driver, 1000).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("idIframe")));
        driver.findElement(By.xpath("//form[@name='emailForm']//input[@type='email']")).sendKeys(email);

        driver.findElement(By.xpath("//form[@name='emailForm']//button[contains(text(),'Send Email')]")).click();

        driver.switchTo().window(tab.get(1));

        new WebDriverWait(driver, 1000).until(ExpectedConditions.visibilityOfElementLocated(By.id("messagesList")));
        driver.findElement(By.id("messagesList")).click();
    }

    @Test
    public void testEqualsPrice() {
        String emailPrice = driver.findElement(By.cssSelector("#mobilepadding > td > table > tbody > tr:nth-child(2) > td:nth-child(2) > h3")).getText();
        String calcPrice = "USD 1,331.77";
        Assert.assertEquals(emailPrice, calcPrice);
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
