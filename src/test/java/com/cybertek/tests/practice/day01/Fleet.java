package com.cybertek.tests.practice.day01;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Fleet {

    public static void main(String[] args) {
        String url = "https://qa2.vytrack.com/user/login";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        WebElement username = driver.findElement(By.xpath("//input[@name='_username']"));
        username.sendKeys("user41");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser123" + Keys.ENTER);

        WebElement fleet = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        fleet.click();
        List<WebElement> vehicles = driver.findElements(By.xpath("//span[@class='title title-level-2']"));
        List<String> expectedVehicles = new ArrayList<>(Arrays.asList("Vehicles","Vehicle Odometer","Vehicle Costs","Vehicle Contracts","Vehicles Fuel Logs","Vehicle Services Logs","Vehicles Model"));

        for (int i = 0; i < vehicles.size(); i++) {
            if (!vehicles.get(i).isDisplayed()) {
                vehicles.remove(i--);
            }
        }
        System.out.println(compareList(vehicles,expectedVehicles));

        for(int i = 0; i<vehicles.size();i++){
            System.out.println(vehicles.get(i).getText());
        }
        driver.quit();
    }
    public static boolean compareList(List<WebElement> vehicles,List<String> expected){

        for (int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i).getText().equals(expected.get(i))){
                return true;
            }
        }
        return false;
    }
}
