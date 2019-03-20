import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HurtMePlenty {
    private WebDriver driver;

    public HurtMePlenty() {
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void testHurtMePlenty() {
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
    }

    @Test
    public void testVMClass() {
        String vmClass = driver.findElement(By.id("select_value_label_41")).getText().toLowerCase();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='resultBlock']//*[contains(text(),'" + vmClass + "')]")).isDisplayed());
    }

    @Test
    public void testInstanceType() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='resultBlock']//*[contains(text(),'Instance type: n1-standard-8')]")).isDisplayed());
    }

    @Test
    public void testRegion() {
        String[] region = " ".split(driver.findElement(By.id("select_option_196")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='resultBlock']//*[contains(text(),'" + region[0] + "')]")).isDisplayed());
    }

    @Test
    public void testLocalSSD() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='resultBlock']//*[contains(text(),'Total available local SSD space 3x375 GB')]")).isDisplayed());
    }

    @Test
    public void testCommitmentTerm() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='resultBlock']//*[contains(text(),'Commitment term: 1 Year')]")).isDisplayed());
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
