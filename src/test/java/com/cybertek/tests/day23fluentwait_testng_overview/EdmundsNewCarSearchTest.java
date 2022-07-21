package com.cybertek.tests.day23fluentwait_testng_overview;

import com.cybertek.pages.EdmundsCarDetailPage;
import com.cybertek.pages.EdmundsHomePage;
import com.cybertek.pages.EdmundsNewCarPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EdmundsNewCarSearchTest extends TestBase {

    @Test
    public void newCarSearchTest(){
        driver.get(ConfigurationReader.getProperty("edmunds.url"));
        EdmundsHomePage homePage = new EdmundsHomePage();
        homePage.isCurrentPage();
        homePage.gotoNewCarPricingPage();//basePage

        //going to new car page
        EdmundsNewCarPage newCarPage = new EdmundsNewCarPage();
        newCarPage.selectMake("Toyota");
        newCarPage.selectModel("Camry");
        //enter zipcode and click go
        while (!newCarPage.zipCode.getAttribute("value").equals("")){
            newCarPage.zipCode.sendKeys(Keys.BACK_SPACE);
        }
        newCarPage.zipCode.sendKeys("22102");
        //click on go
        newCarPage.goBtn.click();

        EdmundsCarDetailPage carDetailPage = new EdmundsCarDetailPage();
        WebDriverWait wait2 = new WebDriverWait(driver,5);
        wait2.until(ExpectedConditions.visibilityOf(carDetailPage.msrpRange));
        carDetailPage.isCurrentPage();
        System.out.println("MSRP range = " + carDetailPage.getMsrpRange());
    }
}
