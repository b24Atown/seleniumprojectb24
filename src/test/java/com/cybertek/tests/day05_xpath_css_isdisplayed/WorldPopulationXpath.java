package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorldPopulationXpath {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://worldometers.info/world-population/";
        driver.get(url);
        Thread.sleep(4000);

        //<div class = "maincounter-number"> the path were looking for.
        WebElement currentPop = driver.findElement(By.xpath("//div[@class= 'maincounter-number']"));
        System.out.println(currentPop.getText());

        for(int i = 1; i<=10;i++){
            Thread.sleep(1000);
            System.out.println(i + " - " + currentPop.getText());
        }

        driver.quit();

    }
}
