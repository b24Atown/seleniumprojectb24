package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EdmundsCarDetailPage extends BasePage {

    @FindBy (xpath = "//span[@class='d-inline-block']")
    public WebElement msrpRange;

    public String getMsrpRange(){
        return msrpRange.getText();
    }

    @Override
    public void isCurrentPage() {
        Assert.assertTrue(driver.getTitle().contains("Prices, Reviews, and Pictures | Edmunds"));
    }
}
