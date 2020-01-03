package Hardcore.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Pages {

    private WebDriver driver;

    Pages(WebDriver driver) {
        this.driver = driver;
    }

    ArrayList<String> openNewPage(String url) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(url);
        return tabs;
    }

    void switchTab(ArrayList<String> tabs, int tabNumber) {
        driver.switchTo().window(tabs.get(tabNumber));
    }
}
