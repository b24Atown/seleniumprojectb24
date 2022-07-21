package com.cybertek.tests.day17_upload_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest extends TestBase {

    @Test
    public void alertExampleTest(){
        JavascriptExecutor js = (JavascriptExecutor)(driver);
        //running javascript alert command
        js.executeScript("alert('hello hello')");
        BrowserUtils.sleep(2);
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text - " + alert.getText());
        alert.accept();
    }

    @Test
    public void scrollTest(){
        driver.get(ConfigurationReader.getProperty("scroll.url"));
        BrowserUtils.sleep(2);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,5000)");

        for (int i = 0; i<10;i++){
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,1000)");
        }
    }

    @Test
    public void scrollToElementTest(){
        driver.get(ConfigurationReader.getProperty("amazon.url"));
        //locate model y element
        WebElement exploreNow = driver.findElement(By.xpath("//a[.='Explore now']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)", exploreNow);
        BrowserUtils.sleep(2);
        WebElement sellOnAmazon = driver.findElement(By.linkText("Sell on Amazon"));
        js.executeScript("arguments[0].scrollIntoView(true)", sellOnAmazon);

    }

    @Test
    public void setValueUsingJSTest(){
        driver.get(ConfigurationReader.getProperty("facebook.url"));
        WebElement userName = driver.findElement(By.id("email"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].value='hello@gmail.com'",userName);
    }
    @Test
    public void sdfsd(){
        driver.get("https://www.google.ca");
        WebElement searchBar = driver.findElement(By.name("q"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='wooden spoon'",searchBar);
        WebElement googleSearch = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
        googleSearch.click();
        WebElement resre = driver.findElement(By.xpath("//h3[.='Reservations | Wooden Spoon']"));
        actions.moveToElement(resre).click().perform();
    }
}
