package com.cybertek.tests.day15_properties_driverutil_testbase;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TechlisticWebtableTest extends TestBase {


    /*
    Go to "https://www.techlistic.com/p/demo-selenium-practice.html"
    Assert current url contains
     */

    @Test
    public void tallBuildingsTableTest(){
        driver.get(ConfigurationReader.getProperty("techlistic.url"));
        List<WebElement> buildings = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr/th"));
        for (WebElement each: buildings){
            System.out.println("Building name = " + each.getText());
        }
        //Assert.assertTrue();
        //getting buildings line
        /*
        //table[@class='tsc_table_s13']//td[contains(.,'buildings')]
        //table[@class='tsc_table_s13']/tfoot/tr/td
         */
    }
}
