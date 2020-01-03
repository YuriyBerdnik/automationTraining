package HurtMePlenty.Pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver driver;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    final int WAIT_FOR_ELEMENT_SECONDS = 10;

    protected abstract AbstractPage openPage();
}
