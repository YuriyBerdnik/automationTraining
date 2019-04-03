package Hardcore.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    WebDriver driver;

    final int WAIT_FOR_ELEMENT_SECONDS = 20;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract AbstractPage openPage();
}
