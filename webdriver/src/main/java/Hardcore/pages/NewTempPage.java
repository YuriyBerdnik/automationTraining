package Hardcore.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewTempPage extends AbstractPage {

    private final String PAGE_URL = "https://temp-mail.org/ru/";

    @FindBy(id = "mail")
    private WebElement emailTempAddress;

    public String getPAGE_URL() {
        return PAGE_URL;
    }

    public String getEmailTempAddress() {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.visibilityOf(emailTempAddress));
        return emailTempAddress.getAttribute("value");
    }

    public NewTempPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public NewTempPage openPage() {
        String PAGE_URL = "https://temp-mail.org/ru/";
        driver.get(PAGE_URL);
        return this;
    }
}
