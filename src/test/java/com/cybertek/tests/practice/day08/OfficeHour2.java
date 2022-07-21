package com.cybertek.tests.practice.day08;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import com.cybertek.utils.OfficeUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OfficeHour2 extends TestBase {

    @Test
    public void placeOrder(){
        driver.get(ConfigurationReader.getProperty("demoblaze.url"));
        int expectedPrice =0;
        //adding laptops sony vaio i7
        expectedPrice+= OfficeUtils.addProduct("Laptops","Sony vaio i7");
        //adding iphone
        expectedPrice+=OfficeUtils.addProduct("Phones", "Iphone 6 32gb");
        //adding Monitor
        expectedPrice+=OfficeUtils.addProduct("Monitors","Apple monitor 24");
        System.out.println(expectedPrice);

        OfficeUtils.getLink("Cart").click();

        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//table//tr/td[contains(.,'Sony vaio i7')]/..//td[.='Delete']/a")).click();

        System.out.println(OfficeUtils.removeProduct("Iphone"));

    }

}
