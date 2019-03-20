import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BringItOn {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        driver.manage().window().maximize();

        WebElement searchInput = driver.findElement(By.id("paste_code"));
        searchInput.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");

        driver.findElement(By.name("paste_format")).sendKeys("Bash");

        driver.findElement(By.name("paste_expire_date")).sendKeys("10 Minutes");

        WebElement searchPastName = driver.findElement(By.xpath("//*[@id=\"myform\"]/div[3]/div[5]/div[2]/input"));
        searchPastName.sendKeys("how to gain dominance among developers");

        driver.findElement(By.id("submit")).click();

        driver.findElement(By.className("paste_box_line1"));
        System.out.println("Заголовок страницы браузера соответствует Paste Name / Title");

        driver.findElement(By.className("buttonsm")).getText();
        System.out.println("Синтаксис подвечен для bash");

        driver.findElement(By.id("paste_code")).getText();
        System.out.println("Код соответствует введенному в пункте 2");

        driver.quit();
    }
}
