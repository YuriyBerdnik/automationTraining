import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICanWin {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");

        WebElement searchInput = driver.findElement(By.id("paste_code"));
        searchInput.sendKeys("Hello from WebDriver");

        driver.findElement(By.name("paste_expire_date")).sendKeys("10 Minutes");

        WebElement searchPastName = driver.findElement(By.xpath("//*[@id=\"myform\"]/div[3]/div[5]/div[2]/input"));
        searchPastName.sendKeys("helloweb");

        driver.findElement(By.id("submit")).click();
    }
}
