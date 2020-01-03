package Hardcore.test;

import Hardcore.pages.CalculatorPage;
import Hardcore.pages.CloudGooglePage;
import Hardcore.pages.MailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ComparePricesTest {
//
//    @Test
//    public void testEmailPriceEqualsCalculator() {
//
//        String calculatedPrice = "USD 1,187.77";
//        String numberOfInstance = "4";
//        String instanceFor = "";
//
//        new CloudGooglePage(driver).openPage().goToCalculatorPage();
//
//        CalculatorPage calculatorPage = new CalculatorPage(driver)
//                .fillInCalculator(numberOfInstance, instanceFor)
//                .openEmailForm();
//
//        ArrayList<String> tabs = new Tabs(driver).openNewTab(new MailPage(driver).getPAGE_URL());
//        String emailAddress = new MailPage(driver).getEmailAddress();
//
//        new Tabs(driver).switchTab(tabs, 0);
//        calculatorPage.fillAndSendEmailFrom(emailAddress);
//
//        new Tabs(driver).switchTab(tabs, 1);
//        String totalPriceFromEmail = new MailPage(driver).openNewMessage().getTotalPriceFromEmail();
//
//        Assert.assertEquals(totalPriceFromEmail, calculatedPrice);
//    }
}
