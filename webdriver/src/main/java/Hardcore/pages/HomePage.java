package Hardcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    private final By buttonExploreAllProducts = By.xpath("//*[@track-name='exploreProducts']");
    private final By buttonSeePricing = By.xpath("//*[@track-name='seePricing']");
    private final By buttonCalculator = By.xpath("//*[@track-name='pricingNav/calculators']");
    private final By formGrid = By.id("idIframe");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToCalculatorPage() {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(buttonExploreAllProducts))
                .click();
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(buttonSeePricing))
                .click();
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(buttonCalculator))
                .click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(formGrid));
        new HomePage(driver);
    }

    @Override
    public HomePage openPage() {
        String PAGE_URL = "https://cloud.google.com/";
        driver.navigate().to(PAGE_URL);
        return this;
    }
}
