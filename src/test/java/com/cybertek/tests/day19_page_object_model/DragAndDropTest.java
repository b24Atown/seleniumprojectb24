package com.cybertek.tests.day19_page_object_model;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestBase {

    @Test
    public void guru99DragAndDropTest(){
        driver.get(ConfigurationReader.getProperty("draganddrop.url"));
        WebElement bank = driver.findElement(By.linkText("BANK"));
        WebElement accountType = driver.findElement(By.id("bank"));

        actions.dragAndDrop(bank,accountType).perform();

        WebElement fivek = driver.findElement(By.linkText("5000"));
        WebElement amount =  driver.findElement(By.id("amt7"));
        actions.dragAndDrop(fivek,amount).perform();
    }

    @Test
    public void cargurusPriceSliderTest(){
        driver.get(ConfigurationReader.getProperty("cargurus.url") + "/Cars/inventorylisting/viewDetailsFilterViewInventoryListing.action?zip=22102&showNegotiable=true&sortDir=ASC&sourceContext=carGurusHomePageModel&distance=75&sortType=DEAL_SCORE&entitySelectingHelper.selectedEntity=d177");
        WebElement priceSlider = driver.findElement(By.xpath("(//button[@role='slider'])[1]"));
        //method down here works but more complicated.
//        actions.clickAndHold(priceSlider).sendKeys(Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT).release().build().perform(); // each arrow right on this website moves it by 1000 dollars.
       actions.dragAndDropBy(priceSlider, 50,0).perform();
    }
}
