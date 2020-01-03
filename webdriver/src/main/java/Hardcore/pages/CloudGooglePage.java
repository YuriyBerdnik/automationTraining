package Hardcore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGooglePage extends AbstractPage {

    @FindBy(xpath = "//*[@track-name='seeProducts']")
    private WebElement buttonSeeProducts;

    @FindBy(xpath = "//*[@track-name='seePricing']")
    private WebElement buttonSeePricing;

    @FindBy(xpath = "//*[@track-name='pricingNav/calculators']")
    private WebElement buttonCalculators;

    public CloudGooglePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CloudGooglePage openPage() {
        String PAGE_URL = "https://cloud.google.com";
        driver.get(PAGE_URL);
        return this;
    }

    public void goToCalculator() {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.elementToBeClickable(buttonSeeProducts));
        buttonSeeProducts.click();
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.elementToBeClickable(buttonSeePricing));
        buttonSeePricing.click();
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.elementToBeClickable(buttonCalculators));
        buttonCalculators.click();
    }
}
