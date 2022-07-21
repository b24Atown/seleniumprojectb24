package com.cybertek.tests.practice.day07;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cybertek.utils.TableUtils.*;

public class TableUtilPractice extends TestBase {

    @Test
    public void TC1(){
        driver.get(ConfigurationReader.getProperty("webtableUrl"));
        printNamesAndEmails(driver);
        Assert.assertTrue(verifyOrder(driver,"John"));
        System.out.println(getCellData(driver, "//table[@id='table1']", 3, 3));
    }
}
