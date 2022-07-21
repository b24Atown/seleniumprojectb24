package com.cybertek.tests.practice.day08;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Prfac extends TestBase {
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
    //TC #4: Selecting value from multiple select dropdown
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    //3. Select all the options from multiple select dropdown.
    //4. Print out all selected values.
    //5. Deselect all values.

    //TC #5: Selecting value from non-select dropdown
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    //3. Click to non-select dropdown
    //4. Select Facebook from dropdown
    //5. Verify title is “Facebook - Log In or Sign Up”

    String url = "http://practice.cybertekschool.com/dropdown";

    @Test
    public void verifyDropdown(){
        driver.get(url);
        Select simpleDropdown = new Select(driver.findElement(By.id("dropdown")));
        Assert.assertEquals(simpleDropdown.getFirstSelectedOption().getText(), "Please select an option","Fail case: wrong option selected");
        Select stateSelection = new Select(driver.findElement(By.id("state")));
        Assert.assertEquals(stateSelection.getFirstSelectedOption().getText(), "Select a State", "Fail case: wrong option selected");
    }

    @Test
    public void tc02test(){
        driver.get(url);
        Select stateSelection = new Select(driver.findElement(By.id("state")));
        stateSelection.selectByIndex(14);
        stateSelection.selectByValue("VA");
        stateSelection.selectByVisibleText("California");
        Assert.assertEquals(stateSelection.getFirstSelectedOption().getText(), "California");
    }

    @Test
    public void tc03test(){
        driver.get(url);
        Select year = new Select(driver.findElement(By.id("year")));
        Select month = new Select(driver.findElement(By.id("month")));
        Select day = new Select(driver.findElement(By.id("day")));
        year.selectByVisibleText("1922");
        month.selectByValue("11");
        day.selectByIndex(0);
    }

    @Test
    public void tc04test(){
        driver.get(url);
        Select languages = new Select(driver.findElement(By.name("Languages")));
        List<WebElement> options = languages.getOptions();

        for (WebElement eachlanguage:options){
            eachlanguage.click();
        }

    }

    @Test
    public void tc05test(){
        driver.get(url);
        WebElement dropdownLink = driver.findElement(By.id("dropdownMenuLink"));
        dropdownLink.click();
        WebElement facebook = driver.findElement(By.xpath("//a[.='Facebook']"));
        facebook.click();
        Assert.assertEquals(driver.getTitle(),"Facebook - Log In or Sign Up");
    }

}
