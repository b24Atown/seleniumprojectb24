package com.cybertek.tests.practice.day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarsDotComUserCarSearchTest {

    String url = "https://www.cars.com";
    public static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test (priority = 1)
    public void defaultValuesTest(){
    String actualTitle = driver.getTitle();
    String expectedTitle = "New Cars, Used Cars, Car Dealers, Prices & Reviews | Cars.com";
        Assert.assertEquals(actualTitle,expectedTitle, "FAIL: title missmatch");
        WebElement icon = driver.findElement(By.xpath("//img[@class='header-logo header-logo__img']"));
        Assert.assertTrue(icon.isDisplayed());
        Assert.assertEquals(makeDropdowns("stock-type").getFirstSelectedOption().getText(),"New & used cars");
        Assert.assertEquals(makeDropdowns("make").getFirstSelectedOption().getText(),"Mitsubishi");
        Assert.assertEquals(makeDropdowns("model").getFirstSelectedOption().getText(),"Outlander");
        Assert.assertEquals(makeDropdowns("price").getFirstSelectedOption().getText(),"No max price");
        Assert.assertEquals(makeDropdowns("distance").getFirstSelectedOption().getText(),"20 miles");
        WebElement zipcode = driver.findElement(By.xpath(" //input[@placeholder=' ']"));
        Assert.assertEquals(zipcode.getAttribute("value"),"");
    }
    @Test (priority=2)
    public void usedTeslaSearchTest(){
        makeDropdowns("stock-type").selectByVisibleText("Used cars");
        makeDropdowns("make").selectByVisibleText("Tesla");
        makeDropdowns("model").selectByVisibleText("Model 3");
        makeDropdowns("price").selectByVisibleText("$50,000");
        makeDropdowns("distance").selectByVisibleText("200 miles");
        WebElement zipcode = driver.findElement(By.xpath(" //input[@placeholder=' ']"));
        zipcode.sendKeys("22102" + Keys.ENTER);
        String header = driver.findElement(By.tagName("h1")).getText();
        Assert.assertTrue(header.contains("Tesla Model 3"));

        String result = driver.findElement(By.xpath("//div[@id='search_form_container']//span[1]")).getText().trim();
        int count = Integer.parseInt(result.substring(0,result.indexOf(" ")));
        Assert.assertTrue(count>200 && count<500, "FAIL: Count isnt between 200 and 500");

        Assert.assertTrue(checkBoxes("model_3").isSelected(),"Model 3 is not selected");
        Assert.assertTrue(driver.findElement(By.xpath("//label[@for='model_tesla-model_s']")).isDisplayed(),"Model s is not displayed");
        Assert.assertFalse(checkBoxes("model_s").isSelected(),"Model S is selected");

    }
    @Test (priority = 3)
    public void usedTeslaAdvancedSearchTest() throws InterruptedException {
        getLink("Advanced search").click();
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());
        List<WebElement>xs = driver.findElements(By.xpath("//span[@class='sds-icon sds-filter__icon']"));
        for (int i = 0; i <2; i++) {
            xs.get(i).click();
        }
        Select make = new Select(driver.findElement(By.xpath("//select[@id='desktop-make_select']")));
        make.selectByVisibleText("Tesla");
        Select distance = new Select(driver.findElement(By.xpath("//select[@id='desktop-location-select']")));
        distance.selectByVisibleText("500 miles");
        Select stockType = new Select(driver.findElement(By.xpath("//select[@id='desktop-stock-type-select']")));
        stockType.selectByVisibleText("Used");

        WebElement zipCode = driver.findElement(By.xpath("//input[@name='zip']"));
        zipCode.clear();
        zipCode.sendKeys("22102");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        List<WebElement> models = driver.findElements(By.xpath("//label[contains(@for,'desktop_tesla-model')]"));
       for(WebElement each: models){
           js.executeScript("arguments[0].click()",each);
       }

       WebElement showAll = driver.findElement(By.xpath("//button[@class='sds-button desktop-form-button']"));
       showAll.click();





    }

    @AfterMethod
    public void tearDown(){
      //  driver.quit();
    }
    public static Select makeDropdowns(String name){
        return new Select(driver.findElement(By.xpath("//select[@data-activitykey='"+name+"']")));
    }
    public static WebElement checkBoxes(String word){
        return driver.findElement(By.xpath("//input[@data-activitykey='model_tesla-"+word+"']"));
    }

    public static WebElement getLink(String link){
        return driver.findElement(By.xpath("//a[.='"+link+"']"));
    }

}
