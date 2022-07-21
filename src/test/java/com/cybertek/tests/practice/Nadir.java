package com.cybertek.tests.practice;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Nadir {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url= "https://qa2.vytrack.com/user/login";
        driver.get(url);

        //<input type="text" id="prependedInput" class="span2" name="_username" value="" required="required" placeholder="Username or Email" autofocus="">

        WebElement userNameField = driver.findElement(By.name("_username"));
        userNameField.sendKeys("user40");

        //<input type="password" id="prependedInput2" class="span2" name="_password" required="required" placeholder="Password" autocomplete="off">

        WebElement passwordField = driver.findElement(By.xpath("//input[@type ='password']"));
        passwordField.sendKeys("UserUser123"+ Keys.ENTER);

//<span class="title title-level-1"><i class="fa-asterisk menu-icon"></i>
//    Fleet</span>

        Thread.sleep(3000);
        WebElement fleetTab= driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        fleetTab.click();

//<span class="title title-level-2">Vehicles</span>
        WebElement vehiclesTab = driver.findElement(By.cssSelector("span[class='title title-level-2']"));
        vehiclesTab.click();
        Thread.sleep(9999);


//<h1 class="oro-subtitle">Cars</h1>
        String actualTitle = driver.getTitle();
        String expected="Car - Entities - System - Car - Entities - System";
        if (expected.equals(actualTitle)){
            System.out.println("Pass: Title verification");
        }else {
            System.out.println("FAil ");
        }


    }
}

