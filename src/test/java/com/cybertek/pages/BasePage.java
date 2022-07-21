package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    /**
     * this class is parent class for all page object classes
     */

    //WebDriver variable just in case any of the children need it
    protected WebDriver driver;
    @FindBy(xpath = "//img[@alt='Home']")
    public WebElement edmundsLogo;

    @FindBy (linkText = "New Car Pricing")
    public WebElement newCarPricingLink;

    public BasePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
       // isCurrentPage(); automatically checks if its the right page when creating a new object of the child page.
    }

    public void gotoNewCarPricingPage(){
        newCarPricingLink.click();
    }

    /**
     * abstrace method to be implemented by child page object classes.
     * This is to verify that we are at correct page
     * using title of the page or anything else
     */
    public abstract void isCurrentPage();
}
