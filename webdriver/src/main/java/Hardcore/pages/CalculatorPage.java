package Hardcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends AbstractPage {

    private final String PAGE_URL = "https://cloud.google.com/products/calculator/";

    @FindBy(xpath = "//md-tab-item/*[@title='Compute Engine']")
    private WebElement itemComputeEngine;

    @FindBy(id = "input_48")
    private WebElement inputNumberInstances;

    @FindBy(id = "input_49")
    private WebElement instancesFor;

    @FindBy(id = "select_value_label_42")
    private WebElement dropdownOS;

    @FindBy(id = "select_option_50")
    private WebElement selectOsOption;

    @FindBy(id = "select_value_label_43")
    private WebElement dropdownVmClass;

    @FindBy(id = "select_option_62")
    private WebElement selectVmClassOption;

    @FindBy(id = "select_value_label_44")
    private WebElement dropdownInstanceType;

    @FindBy(id = "select_option_72")
    private WebElement selectInstanceTypeOption;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement checkboxAddGPUs;

    @FindBy(id = "select_value_label_329")
    private WebElement dropdownNumberGPUs;

    @FindBy(id = "select_option_336")
    private WebElement selectNumberOfGPUsOption;

    @FindBy(id = "select_333")
    private WebElement dropdownGPUsType;

    @FindBy(id = "select_option_343")
    private WebElement selectGPUsTypeOption;

    @FindBy(id = "select_value_label_45")
    private WebElement dropdownLocalSSD;

    @FindBy(id = "select_option_184")
    private WebElement selectLocalSSDOption;

    @FindBy(id = "select_value_label_46")
    private WebElement dropdownDatacenterLocation;

    @FindBy(id = "select_option_198")
    private WebElement selectDatacenterLocationOption;

    @FindBy(id = "select_value_label_47")
    private WebElement dropdownCommitedUsage;

    @FindBy(id = "select_option_102")
    private WebElement selectCommitedUsageOption;

    @FindBy(xpath = "//button[text()='Add to Estimate']")
    private WebElement buttonAddToEstimate;

    @FindBy(id = "email_quote")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//form[@name='emailForm']//button[2]")
    private WebElement buttonSendEmail;

    @FindBy(xpath = "//form[@name='emailForm']//input[@type='email']")
    private WebElement inputEmail;

    private final By formGrid = By.id("idIframe");

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    private void selectDropdownOption(WebElement dropdown, WebElement option) {
        dropdown.click();
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS)
                .until(ExpectedConditions.visibilityOf(option))
                .click();
    }

    public CalculatorPage fillInCalculator(String numberInstance, String NullInstanceFor) {
        itemComputeEngine.click();
        inputNumberInstances.sendKeys(numberInstance);
        instancesFor.sendKeys(NullInstanceFor);
        selectDropdownOption(dropdownOS, selectOsOption);
        selectDropdownOption(dropdownVmClass, selectVmClassOption);
        selectDropdownOption(dropdownInstanceType, selectInstanceTypeOption);
        checkboxAddGPUs.click();
        selectDropdownOption(dropdownNumberGPUs, selectNumberOfGPUsOption);
        selectDropdownOption(dropdownGPUsType, selectGPUsTypeOption);
        selectDropdownOption(dropdownLocalSSD, selectLocalSSDOption);
        selectDropdownOption(dropdownDatacenterLocation, selectDatacenterLocationOption);
        selectDropdownOption(dropdownCommitedUsage, selectCommitedUsageOption);
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.visibilityOf(dropdownCommitedUsage));
        buttonAddToEstimate.click();
        return new CalculatorPage(driver);
    }

    public CalculatorPage openEmailForm() {
        buttonEmailEstimate.click();
        return new CalculatorPage(driver);
    }

    public void fillAndSendEmailFrom(String emailAddress) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(formGrid));
        inputEmail.sendKeys(emailAddress);
        buttonSendEmail.click();
        new CalculatorPage(driver);
    }

    @Override
    public CalculatorPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }
}
