package com.cybertek.tests.day09_testng_dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownHomework {
    //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    //3. Verify “Simple dropdown” default selected value is correct
    //Expected: “Please select an option”
    //4. Verify “State selection” default selected value is correct
    //Expected: “Select a State”
    //TC #2: Selecting state from State dropdown and verifying result
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    //3. Select Illinois
    //4. Select Virginia
    //5. Select California
    //6. Verify final selected option is California.
    //Use all Select options. (visible text, value, index)
    //TC #3: Selecting date on dropdown and verifying
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    //3. Select “December 1st, 1922” and verify it is selected.
    //Select year using : visible text
    //Select month using : value attribute
    //Select day using : index number
    /*
    //TC #4: Selecting value from multiple select dropdown
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    //3. Select all the options from multiple select dropdown.
    //4. Print out all selected values.
    //5. Deselect all values.
     */
    //TC #5: Selecting value from non-select dropdown
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    //3. Click to non-select dropdown
    //4. Select Facebook from dropdown
    //5. Verify title is “Facebook - Log In or Sign Up”

    WebDriver driver;
    String url = "http://practice.cybertekschool.com/dropdown";
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void simpleAndStateSelection(){
        //<option value="" disabled="disabled" selected="selected">Please select an option</option>
        WebElement dropdown = driver.findElement(By.xpath("//option[.='Please select an option']"));
        String expectedDropdown = "Please select an option";
        Assert.assertEquals(dropdown.getText(),expectedDropdown);
        //<option value="" selected="selected">Select a State</option>
        WebElement stateSelection = driver.findElement(By.xpath("//option[text()='Select a State']"));
        String expectedStateSelection = "Select a State";
        Assert.assertEquals(stateSelection.getText(),expectedStateSelection);
    }

    @Test (priority = 2)
    public void stateSelection() {

        WebElement stateSelect = driver.findElement(By.id("state"));
        Select stateSelector = new Select(stateSelect);
        stateSelector.selectByIndex(14);
        stateSelector.selectByVisibleText("Virginia");
        stateSelector.selectByValue("CA");
        Assert.assertEquals(stateSelector.getFirstSelectedOption().getText(),"California");
    }
    @Test (priority = 3)
    public void birthdaySelection(){

        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));
        Select yearDropdown = new Select(year);
        Select monthDropdown = new Select(month);
        Select dayDropdown = new Select(day);
        yearDropdown.selectByVisibleText("1922");
        monthDropdown.selectByValue("11");
        dayDropdown.selectByIndex(0);
        Assert.assertEquals(yearDropdown.getFirstSelectedOption().getText(),"1922");
        Assert.assertEquals(monthDropdown.getFirstSelectedOption().getText(),"December");
        Assert.assertEquals(dayDropdown.getFirstSelectedOption().getText(), "1");
    }

    @Test (priority = 4)
    public void programLanguage(){

        WebElement languages = driver.findElement(By.name("Languages"));
        Select languageSelect = new Select(languages);
        List<WebElement> options = new ArrayList<>();
        for (int i = 0; i<6;i++){
            languageSelect.selectByIndex(i);
            options = languageSelect.getOptions();
            System.out.println(options.get(i).getText());
        }
//        for (WebElement eachElement:options){
//            eachElement.click();
//        }
        languageSelect.deselectAll();
    }

    @Test (priority = 5)
    public void websiteSelector(){
        WebElement dropdownButton = driver.findElement(By.xpath("//a[@role='button']"));
        dropdownButton.click();
        WebElement facebook = driver.findElement(By.xpath("//a[.='Facebook']"));
        facebook.click();
        String title = driver.getTitle();
        Assert.assertEquals(title,"Facebook - Log In or Sign Up");
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
