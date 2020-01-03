package ICanWin.Pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver driver;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract AbstractPage openPage();
}
