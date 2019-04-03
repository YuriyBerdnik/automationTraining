package Hardcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends AbstractPage {

    private final String PAGE_URL = "https://lroid.com/ru/";

    @FindBy(id = "eposta_adres")
    private WebElement mailAddress;

    @FindBy(xpath = "//*[@id='mobilepadding']/descendant::*[contains(text(),'USD')][3]")
    private WebElement totalPrice;

    private final By newMessageGot = By.xpath("//*[contains(@id,'mail')]/a");

    public String getPAGE_URL() {
        return PAGE_URL;
    }

    public MailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getEmailAddress() {
        WebElement emailAddress = new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS)
                .until(ExpectedConditions.visibilityOf(mailAddress));
        return emailAddress.getAttribute("value");
    }

    public MailPage openNewMessage() {
        new WebDriverWait(driver, 100)
                .until(ExpectedConditions.presenceOfElementLocated(newMessageGot))
                .click();
        return new MailPage(driver);
    }

    public String getTotalPriceFromEmail() {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframe")));
        return totalPrice.getText();
    }

    @Override
    public MailPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }
}
