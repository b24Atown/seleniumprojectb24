package com.cybertek.tests.practice.day08;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class JSAlert extends TestBase {

    @Test
    public void alertHandling(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement jsAlertLink = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertLink.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertEquals(driver.findElement(By.cssSelector("#result")).getText(),"You successfuly clicked an alert");

        WebElement jsComfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsComfirm.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();

        WebElement jsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("WHy helloo there");
        alert3.accept();
    }

    @Test
    public void amazonoGuruSearch(){
        driver.get("https://www.amazon.ca");
        Select department = new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
        department.selectByVisibleText("Books");
        Assert.assertEquals(department.getFirstSelectedOption().getText(),"Books");

        List<WebElement> allDepartments = department.getOptions();
        int num = 1;
        for (WebElement each: allDepartments){
            System.out.println("Department " + num++ + " : " + each.getText());
        }
    }

    @Test
    public void carGuru(){
        driver.get("https://www.cargurus.com");
        Assert.assertEquals(driver.getTitle(),"Buy & Sell Cars: Reviews, Prices, and Financing - CarGurus");
        Select make = new Select(driver.findElement(By.id("carPickerUsed_makerSelect")));
        make.selectByVisibleText("Toyota");
        Select model = new Select(driver.findElement(By.id("carPickerUsed_modelSelect")));
        model.selectByValue("d308");
        WebElement zipcode = driver.findElement(By.name("zip"));
        zipcode.sendKeys("90210" + Keys.ENTER);
        WebElement totalListings = driver.findElement(By.xpath("//span[@class='oKvYB4']/strong[2]"));
        int total = Integer.parseInt(totalListings.getText());
        System.out.println(total + " cars");


    }
}
