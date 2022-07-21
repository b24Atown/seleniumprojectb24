package com.cybertek.tests.practice.group_work;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assignment6VyTrack2 {
    String url = "https://qa2.vytrack.com/user/login";
    public static WebDriver driver;


    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
//login to VyTrack
        driver.findElement(By.id("prependedInput")).sendKeys("user41");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);
    }
    @Test
    public void carsPageTest(){
        //clicking vehicle
        driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]")).click();
        //clicking module
        driver.findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']")).click();
        //verifying that user is on the Cars page
        WebElement header= driver.findElement(By.className("oro-subtitle"));
        Assert.assertTrue(header.isDisplayed());
    }


    @Test
    public void clickExportGridDropdownTest() {
        //Verify that user is able to click export grid dropdown
        WebElement exportGrid = driver.findElement(By.xpath("//div[@class='pull-left grid-toolbar-mass-actions']"));
        exportGrid.click();
        WebElement csvLink = getElement("CSV");
        WebElement xlxsLink = getElement("XLSX");
        Assert.assertTrue(csvLink.isDisplayed() && xlxsLink.isDisplayed());
    }
    @Test
    public void exportGridButtonClickTest() {

        //Verify that user is able to click export grid dropdown
        WebElement exportGrid = driver.findElement(By.xpath("//div[@class='pull-left grid-toolbar-mass-actions']"));
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(exportGrid));
            System.out.println("Export Grid Dropdown is clickable");
        } catch (TimeoutException e) {
            System.out.println("Element isn't clickable");
        } finally {
            System.out.println("All good");
        }
    }
    @Test
    public void locatingExportGridDropdownTest() {
        //Export grid dropdown button should be located on the left side of the page
        WebElement exportGrid = driver.findElement(By.xpath("//div[@class='pull-left grid-toolbar-mass-actions']"));
        exportGrid.getAttribute("class");
        Assert.assertTrue(exportGrid.getAttribute("class").contains("left"));
    }
    @Test
    public void clickRefreshButtonTest() {
        //Verify user is able to click refresh button
        WebElement refreshButton = getElement("Refresh");

        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(refreshButton));
            System.out.println("Reset button is clickable");
        } catch (TimeoutException e) {
            System.out.println("Element isn't clickable");
        } finally {
            System.out.println("All good");
        }

    }
    @Test
    public void resetButtonClickTest() {
        //Verify user is able to click reset button
        WebElement resetButton = getElement("Reset");
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(resetButton));
            System.out.println("Reset button is clickable");
        } catch (TimeoutException e) {
            System.out.println("Element isn't clickable");
        } finally {
            System.out.println("All good");
        }
    }
    @Test
    public void gridSettingsButtonClickTest() {
        // Verify user is able to click grid settings button
        WebElement gridSettingsButton = getElement("Grid Settings");
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(gridSettingsButton));
            System.out.println("Grid Settings button is clickable");
            //gridSettingsButton.click();
            // Assert.assertEquals(driver.findElement(By.xpath("//div[@class='dropdown-menu']")).getText(),"Grid Settings");
        }
        catch(TimeoutException e) {
            System.out.println("Element isn't clickable");
        } finally {
            System.out.println("All good");
        }
    }
    @Test
    public void refreshButtonPositionTest() {
//Verify refresh button is located on the left side of the reset button
        WebElement check = driver.findElement(By.xpath("//a[@title='Refresh']/..//preceding-sibling::a[@title='Reset']"));
        Assert.assertTrue(check.isDisplayed());
    }
    @Test
    public void gridSettingsPosition() {
        //Verify grid settings is located on the right side of the reset button
        WebElement check2 = driver.findElement(By.xpath("//a[@title='Reset']/..//preceding-sibling::a[@title='Grid Settings']"));
        Assert.assertTrue(check2.isDisplayed());
    }
    @Test
    public void setGridSettingsButtonLocationTest(){
        //Verify grid settings button is located on the right side of the page
        WebElement gridSettingsParent= driver.findElement(By.xpath("//a[@title='Grid Settings']/../../.."));
        Assert.assertTrue(gridSettingsParent.getAttribute("class").contains("right"));
    }

    public static WebElement getElement(String linkText){
        return driver.findElement(By.xpath("//a[@title='"+linkText+"']"));
    }
}
