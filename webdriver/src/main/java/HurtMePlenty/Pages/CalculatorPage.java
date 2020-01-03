package HurtMePlenty.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CalculatorPage extends AbstractPage {

    @FindBy(id = "idIframe")
    private WebElement frameComputeEngine;

    @FindBy(xpath = "//md-tab-item/*[@title='Compute Engine']")
    private WebElement activateComputeEngine;

    @FindBy(id = "input_51")
    private WebElement inputNumberOfInstances;

    @FindBy(id = "input_52")
    private WebElement inputInstancesFor;

    @FindBy(id = "select_value_label_44")
    private WebElement dropdownOperatingSystemOrSoftware;

    @FindBy(id = "select_option_53")
    private WebElement selectOperatingSystemOrSoftware;

    @FindBy(id = "select_value_label_45")
    private WebElement dropdownMachineClass;

    @FindBy(id = "select_option_65")
    private WebElement selectMachineClass;

    @FindBy(id = "select_value_label_47")
    private WebElement dropdownMachineType;

    @FindBy(id = "select_option_210")
    private WebElement selectMachineType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement chooseAddGPUs;

    @FindBy(id = "select_value_label_333")
    private WebElement dropdownNumberOfGPUs;

    @FindBy(id = "select_option_340")
    private WebElement selectNumberOfGPUs;

    @FindBy(id = "select_337")
    private WebElement dropdownGPUType;

    @FindBy(id = "select_option_347")
    private WebElement selectGPUType;

//    @FindBy(id = "select_76']")
//    private WebElement dropdownLocalSSD;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement dropdownLocalSSD;

    @FindBy(id = "select_option_166")
    private WebElement selectLocalSSD;

//    @FindBy(id = "select_78")
//    private WebElement dropdownDatacenterLocation;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement dropdownDatacenterLocation;

    @FindBy(id = "select_option_180")
    private WebElement selectDatacenterLocation;

    @FindBy(id = "select_value_label_50")
    private WebElement dropdownCommitedUsage;

    @FindBy(id = "select_option_81")
    private WebElement selectCommitedUsage;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimate;


    //        Result Block
    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[2]")
    private WebElement resultMachineClass;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[3]")
    private WebElement resultMachineType;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[4]")
    private WebElement resultDatacenterLocation;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[5]")
    private WebElement resultLocalSSD;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[6]")
    private WebElement resultCommitedUsage;

    @FindBy(xpath = "//*[@id='resultBlock']//*[contains(text(),'Total Estimated Cost')]")
    private WebElement resultCost;

    public void fillInTheForm(String numberOfInstance, String instanseFof) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameComputeEngine));
        activateComputeEngine.click();
        inputNumberOfInstances.sendKeys(numberOfInstance);
        inputInstancesFor.sendKeys(instanseFof);
        dropdownFillInTheForm(dropdownOperatingSystemOrSoftware, selectOperatingSystemOrSoftware);
        dropdownFillInTheForm(dropdownMachineClass, selectMachineClass);
        dropdownFillInTheForm(dropdownMachineType, selectMachineType);
        chooseAddGPUs.click();
        dropdownFillInTheForm(dropdownNumberOfGPUs, selectNumberOfGPUs);
        dropdownFillInTheForm(dropdownGPUType, selectGPUType);
        dropdownFillInTheForm(dropdownLocalSSD, selectLocalSSD);
        dropdownFillInTheForm(dropdownDatacenterLocation, selectDatacenterLocation);
        dropdownFillInTheForm(dropdownCommitedUsage, selectCommitedUsage);
        buttonAddToEstimate.click();
    }

    public void checkDataConsistency() {
        Assert.assertTrue(resultMachineClass.getText().contains("VM class: regular"));
        Assert.assertTrue(resultMachineType.getText().contains("Instance type: n1-standard-8"));
        Assert.assertTrue(resultDatacenterLocation.getText().contains("Region: Frankfurt"));
        Assert.assertTrue(resultLocalSSD.getText().contains("Total available local SSD space 2x375 GB"));
        Assert.assertTrue(resultCommitedUsage.getText().contains("Commitment term: 1 Year"));
        Assert.assertTrue(resultCost.getText().contains("Total Estimated Cost: USD 1,187.77 per 1 month"));
    }

    private void dropdownFillInTheForm(WebElement dropdown, WebElement choose) {
        dropdown.click();
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS).until(ExpectedConditions.visibilityOf(choose)).click();
    }

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CalculatorPage openPage() {
        String PAGE_URL = "https://cloud.google.com/products/calculator/";
        driver.get(PAGE_URL);
        return this;
    }
}
