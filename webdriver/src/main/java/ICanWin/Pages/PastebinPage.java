package ICanWin.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinPage extends AbstractPage {

    @FindBy(id = "paste_code")
    private WebElement enterCode;

    @FindBy(name = "paste_expire_date")
    private WebElement dropdownExpiration;

    @FindBy(name = "paste_name")
    private WebElement enterPastNameOrTitle;

    @FindBy(name = "submit")
    private WebElement createNewPaste;

    public PastebinPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void pastebinPage(String pasteCode, String selectExpiration, String pasteName) {
        enterCode.sendKeys(pasteCode);
        dropdownExpiration.sendKeys(selectExpiration);
        enterPastNameOrTitle.sendKeys(pasteName);
        createNewPaste.click();
    }

    public PastebinPage openPage() {
        String PAGE_URL = "https://pastebin.com";
        driver.get(PAGE_URL);
        return this;
    }
}
